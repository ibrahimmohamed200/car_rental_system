package carrentalsystemproject;


import java.sql.*;
public class DBConncetion {
    private static final String URL = "jdbc:sqlite:carrental.db"; 
    
    public static Connection connectOnlineDB() 
    {    
        Connection connection = null; 
        try { 
            // Load SQLite JDBC Driver 
            Class.forName("org.sqlite.JDBC"); 
 
            // Establish the connection 
            connection  = DriverManager.getConnection(URL); 
           
                System.out.println("Successfully connected to the SQLite database!"); 
             
             return connection;   
        } catch (ClassNotFoundException | SQLException e) { 
           System.out.println("Not connected: " + e.getMessage()); 
           e.printStackTrace();
           return null; 
        }  
         
    } 
}


