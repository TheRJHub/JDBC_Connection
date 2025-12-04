import java.sql.*;

public class SeeTab{
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/advjava";
        String username = "root";
        String password = "rajat123";

        String selectDataSQL = "SELECT * FROM employees";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectDataSQL)) {

            System.out.println("\n📋 EMPLOYEES TABLE DATA:");
            System.out.println("---------------------------------------------");
            System.out.printf("%-5s %-15s %-15s %-10s%n", "ID", "NAME", "DEPARTMENT", "SALARY");
            System.out.println("---------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                double salary = rs.getDouble("salary");

                System.out.printf("%-5d %-15s %-15s %-10.2f%n", id, name, dept, salary);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error while fetching data from 'employees' table!");
            e.printStackTrace();
        }
    }
}