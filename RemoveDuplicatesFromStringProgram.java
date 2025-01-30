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
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (result.indexOf(c) == -1) {
                result += c;
            }
        }
        return result;

    }

}
