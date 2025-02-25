import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Update with your file path
        readCSV(filePath);
    }

    public static void readCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip the header row
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 4) {
                    System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %s%n",
                            data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim());
                } else {
                    System.out.println("Invalid row: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
