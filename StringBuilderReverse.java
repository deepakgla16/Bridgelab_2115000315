public class StringBuilderReverse {
    public static String reverseString(String str) {
        if (str == null || str.isEmpty()) {
            return str; // Handle null and empty string cases
        }
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        String reversed = reverseString(input);
        System.out.println("Reversed String: " + reversed);
    }
}
