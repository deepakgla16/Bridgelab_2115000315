import java.util.HashSet;

public class RemoveDuplicates {
    public static String removeDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return str; // Handle null and empty string cases
        }

        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
        System.out.println("String without duplicates: " + result);
    }
}
