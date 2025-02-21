import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class WordCount {
    public static void main(String[] args) {
        String filePath = "input.txt"; // Change to your file name

        // HashMap to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+"); // Clean and split
                for (String word : words) {
                    if (!word.isEmpty()) { // Ignore empty words
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort words by frequency in descending order
        List<Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display total word count
        int totalWords = wordCountMap.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total Words: " + totalWords);

        // Display top 5 most frequent words
        System.out.println("\nTop 5 Most Frequent Words:");
        for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
            Entry<String, Integer> entry = sortedWords.get(i);
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
