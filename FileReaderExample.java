import java.io.*;

public class FileReaderExample {
    public static void readFile(String filePath) {
        // Try-with-resources to ensure automatic resource management
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Print each line to console
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "sample.txt"; // Change this to your actual file path
        readFile(filePath);
    }
}
