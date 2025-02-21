import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Change this to the actual file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) { // Read line-by-line
                if (line.toLowerCase().contains("error")) { // Case-insensitive search
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
