import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Update file path if necessary
        writeCSV(filePath);
    }

    public static void writeCSV(String filePath) {
        // Define employee data: header row and records
        String[][] employees = {
            {"ID", "Name", "Department", "Salary"},
            {"E001", "Alice Johnson", "HR", "50000"},
            {"E002", "Bob Smith", "IT", "60000"},
            {"E003", "Carol Williams", "Finance", "55000"},
            {"E004", "David Brown", "Marketing", "52000"},
            {"E005", "Emma Davis", "Sales", "58000"}
        };

        // Write data to the CSV file using try-with-resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] employee : employees) {
                writer.write(String.join(",", employee));
                writer.newLine();
            }
            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
