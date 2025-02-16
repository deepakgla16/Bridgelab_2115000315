import java.io.*;

public class WordCountInFile {
    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;

        // Try-with-resources to ensure automatic file closure
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split line into words based on spaces and punctuation
                String[] words = line.split("\\W+"); // \W+ matches non-word characters
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) { // Case-insensitive comparison
                        count++;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        String filePath = "sample.txt"; // Change this to your actual file path
        String targetWord = "Java"; // Change this to the word you want to count

        int occurrences = countWordOccurrences(filePath, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + occurrences + " times in the file.");
    }
}
