import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String filename) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Normalize: Convert to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");

                // Split words by spaces
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return wordCountMap;
    }

    public static void main(String[] args) {
        String filename = "input.txt"; // Change to your file path
        Map<String, Integer> wordFrequency = countWordFrequency(filename);

        System.out.println("Word Frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
