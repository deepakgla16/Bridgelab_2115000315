package Assignment2;
public class NumberChecker3 {

    // Method to find the count of digits in the number
    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    // Method to store the digits of the number in an array
    public static int[] storeDigits(int number) {
        String numStr = String.valueOf(number);
        int[] digits = new int[numStr.length()];

        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';  // Convert char to int
        }

        return digits;
    }

    // Method to reverse the digits array
    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        int j = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            reversed[j++] = digits[i];
        }
        return reversed;
    }

    // Method to compare two arrays and check if they are equal
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a number is a palindrome
    public static boolean isPalindrome(int number, int[] digits) {
        int[] reversedDigits = reverseDigits(digits);
        return areArraysEqual(digits, reversedDigits);
    }

    // Method to check if a number is a Duck number
    public static boolean isDuckNumber(int[] digits) {
        // A Duck number has a non-zero digit somewhere in the number (it can't start with 0)
        for (int digit : digits) {
            if (digit != 0) {
                return true;  // It's a Duck number if any digit is non-zero
            }
        }
        return false;  // It's not a Duck number if no non-zero digits are found
    }

    public static void main(String[] args) {
        int number = 12021;  // Example number for testing

        // Store the digits of the number
        int[] digits = storeDigits(number);

        // Count the digits
        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);

        // Check if the number is a palindrome
        boolean palindrome = isPalindrome(number, digits);
        System.out.println("Is Palindrome: " + palindrome);

        // Check if the number is a Duck number
        boolean duckNumber = isDuckNumber(digits);
        System.out.println("Is Duck Number: " + duckNumber);

        // Reverse the digits and display the reversed array
        int[] reversedDigits = reverseDigits(digits);
        System.out.print("Reversed Digits: ");
        for (int digit : reversedDigits) {
            System.out.print(digit);
        }
        System.out.println();
    }
}
