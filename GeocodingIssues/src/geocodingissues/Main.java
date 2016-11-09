/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocodingissues;

import java.sql.*;
import javax.swing.JOptionPane;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import org.apache.commons.io.IOUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 *
 * @author Izzhov
 */
public class Main {
    private String username = "postgres";
    private String password = "seesomethingclicksomething";
    private static String key = "AIzaSyAWk7neWUDRM2GtdI0FzBjKf3BckOjo-Hs";

    private Connection connection = null;
    public void establishConnection()
    {
        if (connection != null)
            return;
        String url = "jdbc:postgresql://50.177.247.244:5432/scf_data";
        try
        {
           Class.forName("org.postgresql.Driver");
          
           
           connection = DriverManager.getConnection(url, username, password);
           
           if (connection != null) {
               System.out.println("Connecting to database...");
           }
        } catch(Exception e){
            System.out.println("Problem when connecting to the database 1");
        }
    }
    public void addColumns()
    {
        Statement s = null;
        try
        {
            s = connection.createStatement();
            
            s.execute("ALTER TABLE issues "
            + "ADD COLUMN street_no INT, "
            + "ADD COLUMN street VARCHAR(64), "
            + "ADD COLUMN neighborhood VARCHAR(64)");
        }catch(Exception e)
        {
            System.out.println("Problem in altering the database 1");
        }
    }
    public ResultSet getLatLong()
    {
        ResultSet rs = null;
        Statement s = null;
        try
        {
            s = connection.createStatement();
            
            rs = s.executeQuery("SELECT id, latitude, longitude FROM issues ORDER BY id ASC");
        }catch(Exception e)
        {
            System.out.println("Problem in searching the database 1");
        }
        return rs;
    }
    public void closeConnection()
    {
        try
        {
            connection.close();
        }catch(Exception e)
        {
            System.out.println("Problem closing the connection to the database");
        }
    }
    public void insertValues(int id, String street_no, String street)
    {
        //System.out.println("id = " + Integer.toString(id));
        //System.out.println("street_no = " + street_no);
        //System.out.println("street = " + street);
        //System.out.println("neighborhood = " + neighborhood);
        try
        {
            Statement s = connection.createStatement();
            
            s.executeUpdate("UPDATE issues "
            + "SET street_no = " + "'" + street_no + "', "
            + "street = " + "'" + street + "' "
            + "WHERE id = " + Integer.toString(id));
        }catch(Exception e)
        {
            System.out.println("Problem in updating the database street");
        }
    }
    public void insertNbhd(int id, String neighborhood)
    {
        try
        {
            Statement s = connection.createStatement();
            
            s.executeUpdate("UPDATE issues "
            + "SET neighborhood = " + "'" + neighborhood + "'" + " "
            + "WHERE id = " + Integer.toString(id));
        }catch(Exception e)
        {
            System.out.println("Problem in updating the database neighborhood");
        }
    }
    public void insertLocality(int id, String locality)
    {
        try
        {
            Statement s = connection.createStatement();
            
            s.executeUpdate("UPDATE issues "
            + "SET locality = " + "'" + locality + "'" + " "
            + "WHERE id = " + Integer.toString(id));
        }catch(Exception e)
        {
            System.out.println("Problem in updating the database locality");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JSONException  {
        Main x = new Main();
        ResultSet rs = null;
        
        x.establishConnection();
        //x.addColumns(); //already did this
        
        rs = x.getLatLong();
        
        int id;
        double latitude;
        double longitude;
        String req;
        
        String street_no;
        String street;
        String neighborhood;
        String locality;
        
        JSONObject jObject;
        JSONArray resultArray;
        JSONArray compArray;
        
        try {
        while(rs.next())
        {
            id = rs.getInt("id");
            latitude = rs.getDouble("latitude");
            longitude = rs.getDouble("longitude");
            
            //System.out.println("id: " + id);
            
            req = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + Double.toString(latitude)
                    + "," + Double.toString(longitude) + "&result_type=street_address&key=" + key;
            
            try{
            URL url = new URL(req + "&sensor=false");
            URLConnection conn = url.openConnection();
            ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
            IOUtils.copy(conn.getInputStream(), output);
            output.close();
            req = output.toString();
            } catch(Exception e)
            {
                System.out.println("Geocoding Error");
            }
            if(req.contains("OVER_QUERY_LIMIT"))
            {
                System.out.println("Over Daily Query Limit");
                System.exit(0);
            }
            if(!req.contains("ZERO_RESULTS"))
            {
                //System.out.println("req: ");
                //System.out.println(req);
                jObject = new JSONObject(req);
                resultArray = jObject.getJSONArray("results");
                compArray = resultArray.getJSONObject(0).getJSONArray("address_components");//component array
                //store components
                street_no = compArray.getJSONObject(0).getString("long_name");
                street = compArray.getJSONObject(1).getString("long_name");
                x.insertValues(id, street_no, street);
            }
            
            //System.out.println("streetdone");
            
            req = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + Double.toString(latitude)
                    + "," + Double.toString(longitude) + "&result_type=neighborhood&key=" + key;
            try{
            URL url = new URL(req + "&sensor=false");
            URLConnection conn = url.openConnection();
            ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
            IOUtils.copy(conn.getInputStream(), output);
            output.close();
            req = output.toString();
            } catch(Exception e)
            {
                System.out.println("Geocoding Error");
            }
            if(req.contains("OVER_QUERY_LIMIT"))
            {
                System.out.println("Over Daily Query Limit");
                System.exit(0);
            }
            if(!req.contains("ZERO_RESULTS"))
            {
                jObject = new JSONObject(req);
                resultArray = jObject.getJSONArray("results");
                compArray = resultArray.getJSONObject(0).getJSONArray("address_components");//component array
                //store components
                neighborhood = compArray.getJSONObject(0).getString("long_name");
                //now we have to insert these values into the table
                x.insertNbhd(id, neighborhood);
            }
            
            //System.out.println("nbhddone");
            
            req = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + Double.toString(latitude)
                    + "," + Double.toString(longitude) + "&result_type=locality&key=" + key;
            try{
            URL url = new URL(req + "&sensor=false");
            URLConnection conn = url.openConnection();
            ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
            IOUtils.copy(conn.getInputStream(), output);
            output.close();
            req = output.toString();
            } catch(Exception e)
            {
                System.out.println("Geocoding Error");
            }
            if(req.contains("OVER_QUERY_LIMIT"))
            {
                System.out.println("Over Daily Query Limit");
                System.exit(0);
            }
            if(!req.contains("ZERO_RESULTS"))
            {
                jObject = new JSONObject(req);
                resultArray = jObject.getJSONArray("results");
                compArray = resultArray.getJSONObject(0).getJSONArray("address_components");//component array
                //store components
                locality = compArray.getJSONObject(0).getString("long_name");
                //now we have to insert these values into the table
                x.insertLocality(id, locality);
            }
        }
        } catch(Exception e)
        {
            System.out.println("Problem when updating the database.");
        }
        x.closeConnection();
    }
    
}
