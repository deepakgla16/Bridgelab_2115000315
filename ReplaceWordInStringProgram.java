import java.util.Scanner;

public class ReplaceWordInStringProgram {
    private static String replaceWord(String str, String wordToReplace, String newWord) {
        return str.replace(wordToReplace, newWord);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println("Enter the word to replace and new word respectively:");
        String wordToReplace = input.next();
        String newWord = input.next();
        String modifiedString = replaceWord(str, wordToReplace, newWord);
        System.out.printf("Modified String: \"%s\"", modifiedString);
        input.close();
    }
}
