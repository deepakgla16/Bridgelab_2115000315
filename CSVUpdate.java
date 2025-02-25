import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUpdate {
    public static void main(String[] args) {
        String inputFilePath = "employees.csv"; // Original file
        String outputFilePath = "updated_employees.csv"; // Updated file
        updateSalaries(inputFilePath, outputFilePath);
    }

    public static void updateSalaries(String inputFilePath, String outputFilePath) {
        List<String[]> records = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (isHeader) {
                    isHeader = false;
                } else if (data.length == 4 && data[2].trim().equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[3].trim());
                    salary *= 1.10; // Increase salary by 10%
                    data[3] = String.format("%.2f", salary);
                }
                records.add(data);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Write updated records to the new CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String[] record : records) {
                writer.write(String.join(",", record));
                writer.newLine();
            }
            System.out.println("Updated CSV file saved as: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
