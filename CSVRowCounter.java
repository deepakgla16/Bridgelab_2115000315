import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVRowCounter {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Update with your CSV file path
        int recordCount = countRows(filePath);
        System.out.println("Total records (excluding header): " + recordCount);
    }

    public static int countRows(String filePath) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip the header row
                    isHeader = false;
                    continue;
                }
                count++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return count;
    }
}
