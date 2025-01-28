package Assignment2;
import java.util.ArrayList;

public class NumberChecker {

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

    // Method to check if a number is a Duck Number
    public static boolean isDuckNumber(int[] digits) {
        // A Duck Number must have at least one non-zero digit
        for (int digit : digits) {
            if (digit != 0) {
                return true;  // Non-zero digit found, it's a Duck Number
            }
        }
        return false;  // If all digits are zero
    }

    // Method to check if a number is an Armstrong Number
    public static boolean isArmstrongNumber(int[] digits, int number) {
        int sum = 0;
        int numDigits = digits.length;

        for (int digit : digits) {
            sum += Math.pow(digit, numDigits);
        }

        return sum == number;  // If sum equals the original number, it's an Armstrong number
    }

    // Method to find the largest and second largest elements in the digits array
    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }

        return new int[]{largest, secondLargest};
    }

    // Method to find the smallest and second smallest elements in the digits array
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }

        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        int number = 153;  // Example number for testing
        int[] digits = storeDigits(number);

        // Count of digits in the number
        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);

        // Check if it's a Duck Number
        boolean isDuck = isDuckNumber(digits);
        System.out.println("Is Duck Number: " + isDuck);

        // Check if it's an Armstrong Number
        boolean isArmstrong = isArmstrongNumber(digits, number);
        System.out.println("Is Armstrong Number: " + isArmstrong);

        // Find the largest and second largest digits
        int[] largestAndSecondLargest = findLargestAndSecondLargest(digits);
        System.out.println("Largest digit: " + largestAndSecondLargest[0]);
        System.out.println("Second largest digit: " + largestAndSecondLargest[1]);

        // Find the smallest and second smallest digits
        int[] smallestAndSecondSmallest = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest digit: " + smallestAndSecondSmallest[0]);
        System.out.println("Second smallest digit: " + smallestAndSecondSmallest[1]);
    }
}
