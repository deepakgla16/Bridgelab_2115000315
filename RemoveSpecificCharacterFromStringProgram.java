import java.util.Scanner;

public class RemoveSpecificCharacterFromStringProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        char ch = input.next().charAt(0);
        String modifiedString = removeCharacter(str, ch);
        System.out.printf("Modified String: \"%s\"", modifiedString);
        input.close();
    }

    private static String removeCharacter(String str, char ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    
}
