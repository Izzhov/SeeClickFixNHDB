/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocodingsql;

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
    private static String key = "";
    
    private Connection connection = null;
    public void establishConnection()
    {
        if (connection != null)
            return;
        String url = "jdbc:postgresql://50.177.247.244:5432/mydb";
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
    public ResultSet giveName()
    {
        ResultSet rs = null;
        Statement s = null;
        try
        {
            s = connection.createStatement();
            
            rs = s.executeQuery("SELECT * FROM words WHERE word_order < 3");
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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JSONException {
        Main x = new Main();
        ResultSet rs = null;
        String string = "";

        x.establishConnection();
        rs = x.giveName();
        
        try {
        while(rs.next())
        {
            string += rs.getString(1) + " ";
        }

        JOptionPane.showMessageDialog(null, string, "authors", 1);
        } catch(Exception e)
        {
            System.out.println("Problem when printing the database.");
        }
        x.closeConnection();
        
        // Now do Geocoding
        String req = "https://maps.googleapis.com/maps/api/geocode/json?latlng=41.3166662867211,-72.9062497615814&result_type=point_of_interest&key=" + key;
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
        JSONObject jObject = new JSONObject(req);
        JSONArray resultArray = jObject.getJSONArray("results");
        //this prints out the neighborhood of the provided coordinates
        System.out.println(resultArray.getJSONObject(0).getJSONArray("address_components").getJSONObject("neighborhood").getString("long_name"));
    }
    
}
