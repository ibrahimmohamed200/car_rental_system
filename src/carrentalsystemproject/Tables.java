package carrentalsystemproject;

import java.sql.*;

public class Tables {
    Connection con = DBConncetion.connectOnlineDB();
    Statement st = null;

    public void CreateTables() {
        String sql1=
              "CREATE TABLE IF NOT EXISTS Group16_LogIn(Username VARCHAR(100), Password VARCHAR(100));" ;
        String sql2 =  
            "CREATE TABLE IF NOT EXISTS Group16_CarRegistrationTable(ID INTEGER PRIMARY KEY AUTOINCREMENT, CarRegNo VARCHAR(100), Brand VARCHAR(100), Model VARCHAR(100), Available VARCHAR(100));";
        String sql3 =
            "CREATE TABLE IF NOT EXISTS Group16_CustomerRegistrationTable(ID INTEGER PRIMARY KEY AUTOINCREMENT, CustomerID VARCHAR(100), Name VARCHAR(100), Address VARCHAR(100), Mobile VARCHAR(15));";
        String sql4 =
            "CREATE TABLE IF NOT EXISTS Group16_Rents(ID INTEGER PRIMARY KEY AUTOINCREMENT, CarID VARCHAR(100), CustomerID VARCHAR(100), Fee INT(10), DateOut VARCHAR(100), DateDueIn VARCHAR(100));";
        String sql5 =
            "CREATE TABLE IF NOT EXISTS Group16_ReturnCar(ID INTEGER PRIMARY KEY AUTOINCREMENT, CarID VARCHAR(100), CustomerID VARCHAR(100), ReturnDate VARCHAR(100), DaysElapsed INT(10), Fine INT(10));";

        try {
            st = con.createStatement();
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);
            st.executeUpdate(sql3);
            st.executeUpdate(sql4);
            st.executeUpdate(sql5);

            System.out.println("Tables created successfully");
        } catch (SQLException e) {
            System.out.println("Tables not created: " + e.getMessage());
        }
    }
}


