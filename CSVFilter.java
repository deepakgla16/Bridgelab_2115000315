import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVFilter {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Update with your file path
        filterRecords(filePath);
    }

    public static void filterRecords(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            System.out.println("Students who scored more than 80 marks:");
            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip the header row
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 4) {
                    int marks = Integer.parseInt(data[3].trim());
                    if (marks > 80) {
                        System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %d%n",
                                data[0].trim(), data[1].trim(), data[2].trim(), marks);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
