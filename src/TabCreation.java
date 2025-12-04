import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TabCreation {

    public static void main(String[] args) {
        // Database connection details
        String jdbcUrl = "jdbc:mysql://localhost:3306/advjava";
        String username = "root";
        String password = "rajat";

        // SQL statements
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS employees (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                department VARCHAR(100),
                salary DECIMAL(10, 2)
            )
        """;

        String insertDataSQL = """
            INSERT INTO employees (name, department, salary)
            VALUES 
                ('Alice', 'HR', 50000.00),
                ('Bob', 'IT', 65000.50),
                ('Charlie', 'Finance', 72000.75)
        """;
        // Try-with-resources ensures connection closes automatically
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement()) {

            // Create table
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'employees' created (if not already).");

            // Insert data
            int rowsInserted = stmt.executeUpdate(insertDataSQL);
            System.out.println(rowsInserted + " rows inserted into 'employees' table.");

        } catch (SQLException e) {
            System.out.println("Error while creating table or inserting data!");
            e.printStackTrace();
        }

    }
}
