import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;

        System.out.print("Enter a string: ");
        str = input.nextLine();

        if (isPalindrome(str)) {
            System.out.println(str + " is a palindrome.");
        } 
        else {
            System.out.println(str + " is not a palindrome.");
        }

        input.close();
    }

    public static boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
