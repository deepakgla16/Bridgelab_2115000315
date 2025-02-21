import java.io.*;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        String filePath = "data.txt"; // File to read

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) { // Read and print file content
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found"); // Handle missing file case
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage()); // Handle other IO errors
        }
    }
}
