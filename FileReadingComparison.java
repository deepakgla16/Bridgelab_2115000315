import java.io.*;

public class FileReadingComparison {
    public static void main(String[] args) {
        String filePath = "large_file.txt"; // Replace with your actual file path

        System.out.println("Reading using FileReader...");
        long start = System.nanoTime();
        readFileWithFileReader(filePath);
        long fileReaderTime = System.nanoTime() - start;
        System.out.println("FileReader Time: " + (fileReaderTime / 1_000_000.0) + " ms");

        System.out.println("\nReading using InputStreamReader...");
        start = System.nanoTime();
        readFileWithInputStreamReader(filePath);
        long inputStreamReaderTime = System.nanoTime() - start;
        System.out.println("InputStreamReader Time: " + (inputStreamReaderTime / 1_000_000.0) + " ms");
    }

    // Reads file using FileReader (Character Stream)
    private static void readFileWithFileReader(String filePath) {
        try (FileReader reader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(reader)) {

            while (br.read() != -1) { } // Read each character
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Reads file using InputStreamReader (Byte Stream)
    private static void readFileWithInputStreamReader(String filePath) {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader br = new BufferedReader(reader)) {

            while (br.read() != -1) { } // Read each byte and convert to character
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
