package PostgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Way1_Connection_ {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5431/practice";
        String username = "postgres";
        String password = "****";

        System.out.println("Checking SQL Database Connectivity...");

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            if (connection != null) {
                System.out.println("Successfully connected to the database...!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}
