import java.io.*;
import java.sql.*;

public class DatabaseToCSV {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; // Change DB URL
        String dbUser = "your_username"; // Change DB Username
        String dbPassword = "your_password"; // Change DB Password
        String outputFile = "employees.csv"; // Output CSV file

        exportDataToCSV(jdbcURL, dbUser, dbPassword, outputFile);
    }

    public static void exportDataToCSV(String jdbcURL, String dbUser, String dbPassword, String outputFile) {
        String query = "SELECT EmployeeID, Name, Department, Salary FROM Employees"; // Adjust table name
        
        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            // Write CSV Header
            bw.write("EmployeeID,Name,Department,Salary\n");

            // Write records
            while (rs.next()) {
                int id = rs.getInt("EmployeeID");
                String name = rs.getString("Name");
                String department = rs.getString("Department");
                double salary = rs.getDouble("Salary");

                bw.write(id + "," + name + "," + department + "," + salary + "\n");
            }

            System.out.println("CSV file created successfully: " + outputFile);

        } catch (SQLException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
