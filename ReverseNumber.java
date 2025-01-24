package Assignment2;
import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Find the count of digits in the number
        int count = (int) Math.log10(number) + 1;

        // Create an array to store the digits of the number
        int[] digits = new int[count];

        // Extract the digits and store them in the digits array
        for (int i = 0; i < count; i++) {
            digits[i] = number % 10;  // Get the last digit
            number = number / 10;     // Remove the last digit
        }

        // Create an array to store the digits in reverse order
        int[] reversedDigits = new int[count];

        // Reverse the digits into the reversedDigits array
        for (int i = 0; i < count; i++) {
            reversedDigits[i] = digits[count - 1 - i];  // Reverse the array
        }

        // Display the digits in reverse order
        System.out.print("Reversed number: ");
        for (int digit : reversedDigits) {
            System.out.print(digit);
        }
        System.out.println();  // Newline after the output

        // Close the scanner
        scanner.close();
    }
}
