import java.util.Scanner;

public class SubstringOccurenceProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the string and substring repectively");
        String str = input.nextLine();
        String subStr = input.nextLine();
        int occurrences = countSubstringOccurrences(str, subStr);
        System.out.printf("The substring \"%s\" occurs %d times in the string \"%s\"", subStr, occurrences, str);
        input.close();
    }
    
    private static int countSubstringOccurrences(String str, String subStr) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == subStr.charAt(0)) {
                int j = 0;
                while(j < subStr.length() && i+j < str.length() && str.charAt(i+j) == subStr.charAt(j)) {
                    j++;
                }
                    
                if(j == subStr.length()){
                    count++;
                }
            }
        }
        return count;
    }
}
