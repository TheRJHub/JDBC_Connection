import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{

    public static void main(String[] args) {
        // Replace with your actual database details
        String jdbcUrl = "jdbc:mysql://localhost:3306/advjava";
        String username = "root";
        String password = "rajat";

        System.out.println("Checking SQL Database Connectivity...");

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            if (connection != null) {
                System.out.println("✅ Successfully connected to the database!");
            } else {
                System.out.println("❌ Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed!");
            e.printStackTrace();
        }
    }
}
