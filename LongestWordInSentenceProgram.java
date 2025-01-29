import java.util.Scanner;

public class LongestWordInSentenceProgram {
    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        
		String str = input.nextLine();
		String[] words = splitString(str);
		int[] lengths = getLengths(words);
		int result = maxLength(lengths);
		System.out.printf("Longest word in a string is \"%s\"", words[result]);
		input.close();
	}

	public static int countWords(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) 
            if (str.charAt(i) == ' ') {
                count++;
            }
        return count + 1;
    }

    private static int[] getLengths(String[] words) {
        int[] lengths = new int[words.length];
        for (int i = 0; i < words.length; i++) 
            lengths[i] = words[i].length();
        return lengths;
    }
	
	private static int maxLength(int[] lengths) {
		int maxLen = Integer.MIN_VALUE, index = 0;
		for(int i=0; i<lengths.length; i++) {
			if(maxLen < lengths[i]) {
				maxLen = lengths[i];
				index = i;
			}
		}
		return index;
	}
	
	private static String[] splitString(String str) {
        String[] words = new String[countWords(str)];
        int wordCount = 0;
        String word = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                words[wordCount++] = word;
                word = "";
            } else 
                word += ch;
        }
        words[wordCount] = word;
        return words;
    }
}
