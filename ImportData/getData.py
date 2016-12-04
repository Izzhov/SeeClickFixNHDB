#!/usr/bin/python3
# Author: Emon Datta (emdat)
# Downloads SeeClickFix data and saves to database tables. 

import requests
import psycopg2
user_ids = []
request_types = []

# Add the specified user to the users table if it has not already been entered.
def add_user(conn, cur, user):

    # Check if we have already added information for this user. 
    if user['id'] in user_ids:
        return
    user_ids.append(user['id'])
    try: 
        user_exists = cur.execute("""SELECT EXISTS (SELECT 1 FROM test_users WHERE id=%s);""", (user['id'],))
    except Exception as e:
        print("could not look for user: ", end='')
        print(e)
        conn.rollback()
        user_exists = False

    # If we do not already have the user's info in the table, add it. 
    if not user_exists:
        try:
            cur.execute("""INSERT INTO test_users(id, name, witty_title, role, civic_points) VALUES(%s, %s, %s, %s, %s);""", (user['id'], user['name'], user['witty_title'], user['role'], user['civic_points'],))
        except Exception as e:
            print('user exception: ', end='')
            print(e)
            conn.rollback()

def add_request_type(conn, cur, request_type):
    if request_type['id'] in request_types:
        return
    request_types.append(request_type['id'])
    try: 
        request_type_exists = cur.execute("""SELECT EXISTS (SELECT 1 FROM test_request_types WHERE id=%s);""", (request_type['id'],))
    except Exception as e:
        print("could not look for request: ", end='')
        print(e)
        conn.rollback()
        request_type_exists = False
    if not request_type_exists:
        try:
            cur.execute("""INSERT INTO test_request_types(id, name) VALUES(%s, %s);""", (request_type['id'], request_type['title'],))
        except Exception as e:
            print('request type exception: ', end='')
            print(e)
            conn.rollback()


# Base url to retrive New Haven issues from SeeClickFix API
url = 'https://seeclickfix.com/api/v2/issues?page=1&per_page=30&details=true&status=open,acknowledged,closed,archived&place_url=new-haven-county'

# Connect to database
conn = psycopg2.connect(database="mydb", user="postgres", password="havens1260havenots", host="50.177.247.244")
conn.autocommit = True
cur = conn.cursor()

while url:
    r = requests.get(url)
    tries = 0;

    # Moved permanantly
    if r.status_code is 301: 
        url = r.headers['Location']
        continue;

    # Moved temporarily
    if r.status_code is 302: 
        r = requests.get(r.headers['Location'])

    # Server error: retry
    while r.status_code is 500 and tries<=50: 
        r = requests.get(url)
        tries+=1;

    # Persistent erver errors or client errors
    if tries > 50 or r.status_code is 400 or r.status_code is 422:
        break;

    # Attempt to retrieve json
    try:
        data = r.json()
    except:
        print("cannot get json data")
        break;

    issues = data['issues'];
    if issues is None or len(issues)<=0:
        break;

    # Add comments, questions, users (reporters/assignees) to separate tables
    for issue in issues:

        # Skip if no issue id
        if not issue['id']:
            continue

        # Take care of assignee id if null
        if not issue['assignee']:
            assignee_id = None
        else:
            assignee_id = issue['assignee']['id']

        # Take care of reporter id if null
        if not issue['reporter']:
            reporter_id = None
        else:
            reporter_id = issue['reporter']['id']

        # Take care of request type id if null
        if not issue['request_type']:
            request_type_id = None
        else:
            request_type_id = issue['request_type']['id']

        # Attempt to add the issue information into the table
        try:
            cur.execute("""INSERT INTO test_issues_new_haven(id, status, summary, description, rating, latitude, longitude, address, created_at, acknowledged_at, closed_at, reopened_at, updated_at, comment_count, vote_count, request_type_id, reporter_id, assignee_id) VALUES(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s);""", (issue['id'], issue['status'], issue['summary'], issue['description'], issue['rating'], issue['lat'], issue['lng'], issue['address'], issue['created_at'], issue['acknowledged_at'], issue['closed_at'], issue['reopened_at'], issue['updated_at'], issue['comments_count'], issue['vote_count'], request_type_id, reporter_id, assignee_id,))
        except Exception as e:
            print('issue exception: ', end='')
            print(e)
            conn.rollback()

        # If the information exists and is not already recorded, add users for reporter and assignee. 
        if reporter_id:
            add_user(conn, cur, issue['reporter'])
        if assignee_id:
            add_user(conn, cur, issue['assignee'])

        # If the information exists and is not already recorded, add request type id/name information. 
        if request_type_id:
            add_request_type(conn, cur, issue['request_type'])

        # If there are any comments for the current issue, add them all to the comments table one by one. 
        if issue['comments_count'] > 0:
            for comment in issue['comments']:
                if not comment['commenter']:
                    commenter_id = None
                else:
                    commenter_id = comment['commenter']['id']
                try:
                    cur.execute("""INSERT INTO test_comments(issue_id, comment, created_at, updated_at, commenter_id) VALUES(%s, %s, %s, %s, %s);""", (issue['id'], comment['comment'], comment['created_at'], comment['updated_at'], commenter_id))
                except Exception as e:
                    print('comment exception: ', end='')
                    print(e)
                    conn.rollback()
                if commenter_id:
                    add_user(conn, cur, comment['commenter'])

        # If there are any questions for the current issue, add them all to the questions table one by one. 
        if issue['questions']:
            for question in issue['questions']:
                try:
                    cur.execute("""INSERT INTO test_questions(issue_id, question, answer) VALUES(%s, %s, %s);""", (issue['id'],question['question'], question['answer']))
                except Exception as e:
                    print('assignee exception: ', end='')
                    print(e)
                    conn.rollback()

    # Retrieve the url for the next page of results. 
    url = data['metadata']['pagination']['next_page_url']
    print('page {} of {}'.format(data['metadata']['pagination']['page'], data['metadata']['pagination']['pages']))

cur.close()
conn.close()