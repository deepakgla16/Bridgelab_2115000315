import java.io.*;

public class PerformanceComparison {
    
    // Method to test StringBuilder and StringBuffer performance
    public static void compareStringConcatenation(int iterations, String text) {
        // StringBuilder Test
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time (ms): " + (endTime - startTime) / 1_000_000);

        // StringBuffer Test
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time (ms): " + (endTime - startTime) / 1_000_000);
    }

    // Method to count words using FileReader
    public static void countWordsUsingFileReader(String filePath) {
        long startTime = System.nanoTime();
        int wordCount = 0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Split by whitespace to count words
            }

        } catch (IOException e) {
            System.err.println("Error reading file with FileReader: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        System.out.println("FileReader word count: " + wordCount);
        System.out.println("FileReader time (ms): " + (endTime - startTime) / 1_000_000);
    }

    // Method to count words using InputStreamReader
    public static void countWordsUsingInputStreamReader(String filePath, String charset) {
        long startTime = System.nanoTime();
        int wordCount = 0;

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }

        } catch (IOException e) {
            System.err.println("Error reading file with InputStreamReader: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        System.out.println("InputStreamReader word count: " + wordCount);
        System.out.println("InputStreamReader time (ms): " + (endTime - startTime) / 1_000_000);
    }

    public static void main(String[] args) {
        // Comparing StringBuilder and StringBuffer performance
        System.out.println("Testing StringBuilder vs StringBuffer...");
        compareStringConcatenation(1_000_000, "hello");

        // File path for testing large file reading (Change to your actual file path)
        String filePath = "large_text_file.txt";  
        String charset = "UTF-8"; 

        // Comparing FileReader and InputStreamReader performance
        System.out.println("\nTesting FileReader vs InputStreamReader...");
        countWordsUsingFileReader(filePath);
        countWordsUsingInputStreamReader(filePath, charset);
    }
}
