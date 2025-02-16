import java.io.*;

public class InputStreamReaderExample {
    public static void readFile(String filePath, String charset) {
        // Try-with-resources to ensure automatic resource closure
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Print each line to console
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "sample2.txt"; // Change this to your actual file path
        String charset = "UTF-8"; // Specify the correct charset for the file

        readFile(filePath, charset);
    }
}
