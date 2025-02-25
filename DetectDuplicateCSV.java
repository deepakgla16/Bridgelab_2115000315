import java.io.*;
import java.util.*;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Update with your CSV file path
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Set<String> idSet = new HashSet<>();  // Stores unique IDs
        List<String> duplicateRecords = new ArrayList<>(); // Stores duplicate records

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length > 0) {
                    String id = data[0].trim(); // ID is assumed to be the first column

                    if (!idSet.add(id)) { // If add() returns false, it's a duplicate
                        duplicateRecords.add(line);
                    }
                }
            }

            // Print duplicate records
            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records Found:");
                for (String record : duplicateRecords) {
                    System.out.println(record);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
