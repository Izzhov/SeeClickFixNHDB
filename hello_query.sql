-- Database: mydb

-- DROP DATABASE mydb;

SELECT word
FROM words
WHERE word_order < 3
ORDER BY word_order ASC;