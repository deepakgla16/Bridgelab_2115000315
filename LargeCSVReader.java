import java.io.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "large_dataset.csv"; // Update with your large CSV file path
        int batchSize = 100; // Process in chunks of 100 lines
        processLargeCSV(filePath, batchSize);
    }

    public static void processLargeCSV(String filePath, int batchSize) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int totalRecords = 0;
            int batchCount = 0;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }

                // Process the line (dummy processing here)
                totalRecords++;
                batchCount++;

                if (batchCount == batchSize) {
                    System.out.println("Processed " + totalRecords + " records so far...");
                    batchCount = 0; // Reset batch counter
                }
            }

            System.out.println("Total records processed: " + totalRecords);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
