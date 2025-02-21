import java.io.*;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        String filePath = "info.txt"; // File to read

        // Try-with-resources ensures automatic closing of BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String firstLine = reader.readLine(); // Read the first line
            if (firstLine != null) {
                System.out.println("First Line: " + firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
