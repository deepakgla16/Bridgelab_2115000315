import java.util.Scanner;

public class AnagramStringProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first string:");
        String str1 = input.nextLine();
        System.out.println("Enter the second string:");
        String str2 = input.nextLine();
        boolean areAnagrams = areAnagrams(str1, str2);
        if (areAnagrams) {
            System.out.println("The two strings are anagrams of each other");
        }
        else {
            System.out.println("The two strings are not anagrams of each other");
        }
        input.close();
    }

    private static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) 
            return false;

        int[] frequency = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            frequency[str1.charAt(i)]++;
            frequency[str2.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (frequency[i] != 0) 
                return false;
        }
        return true;
    }

}
