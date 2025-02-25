import java.io.*;
import java.util.*;

public class CSVSort {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Update with your file path
        sortAndPrintTopSalaries(filePath);
    }

    public static void sortAndPrintTopSalaries(String filePath) {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (isHeader) { // Store header separately
                    isHeader = false;
                    continue;
                }
                records.add(data);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort records by Salary in descending order
        records.sort((a, b) -> {
            double salaryA = Double.parseDouble(a[3].trim());
            double salaryB = Double.parseDouble(b[3].trim());
            return Double.compare(salaryB, salaryA); // Descending order
        });

        // Print the top 5 highest-paid employees
        System.out.println("Top 5 Highest-Paid Employees:");
        int count = Math.min(5, records.size()); // Ensure we don't exceed the number of records
        for (int i = 0; i < count; i++) {
            String[] employee = records.get(i);
            System.out.printf("ID: %s, Name: %s, Department: %s, Salary: %s%n",
                    employee[0].trim(), employee[1].trim(), employee[2].trim(), employee[3].trim());
        }
    }
}
