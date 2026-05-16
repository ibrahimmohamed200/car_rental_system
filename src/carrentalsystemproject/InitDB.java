package carrentalsystemproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InitDB {
    public static void main(String[] args) {
        System.out.println("Initializing database...");
        Tables tables = new Tables();
        tables.CreateTables();
        
        System.out.println("Checking for test user...");
        try (Connection con = DBConncetion.connectOnlineDB()) {
            if (con != null) {
                // Check if admin exists
                PreparedStatement checkPst = con.prepareStatement("SELECT * FROM Group16_LogIn WHERE Username=?");
                checkPst.setString(1, "admin");
                ResultSet rs = checkPst.executeQuery();
                if (!rs.next()) {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Group16_LogIn(Username, Password) VALUES(?, ?)");
                    pst.setString(1, "admin");
                    pst.setString(2, "admin");
                    pst.executeUpdate();
                    System.out.println("Inserted test user: admin / admin");
                } else {
                    System.out.println("Test user already exists.");
                }
            } else {
                 System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting test user: " + e.getMessage());
        }
        System.out.println("Database initialization complete.");
    }
}
