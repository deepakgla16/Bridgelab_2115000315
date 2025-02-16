public class SearchWordInSentences {
    public static String findSentenceWithWord(String[] sentences, String word) {
        // Iterate through the list of sentences
        for (String sentence : sentences) {
            // Check if the sentence contains the specific word
            if (sentence.contains(word)) {
                return sentence; // Return the sentence if the word is found
            }
        }
        return "Not Found"; // Return "Not Found" if no sentence contains the word
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Java is a powerful programming language.",
            "Data structures and algorithms are essential for coding interviews.",
            "Practice makes perfect."
        };

        String wordToFind = "Java"; // Word to search for

        String result = findSentenceWithWord(sentences, wordToFind);
        System.out.println("Result: " + result);
    }
}
