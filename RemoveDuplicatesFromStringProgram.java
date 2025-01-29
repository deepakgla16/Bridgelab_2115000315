import java.util.Scanner;

public class RemoveDuplicatesFromStringProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String modifiedString = removeDuplicates(str);
        System.out.printf("After removing duplicates from \"%s\", the modified string is \"%s\"", str, modifiedString);
        input.close();
    }

    private static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (sb.indexOf(String.valueOf(ch)) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
}
