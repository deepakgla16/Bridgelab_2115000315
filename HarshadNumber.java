package Assignment2;
import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Initialize sum to 0
        int sum = 0;
        int originalNumber = number;

        // Calculate the sum of digits
        while (number != 0) {
            int digit = number % 10;  // Get the last digit
            sum += digit;             // Add the digit to sum
            number /= 10;             // Remove the last digit
        }

        // Check if the number is divisible by the sum of its digits
        if (originalNumber % sum == 0) {
            System.out.println(originalNumber + " is a Harshad number.");
        } else {
            System.out.println(originalNumber + " is not a Harshad number.");
        }

        scanner.close();
    }
}
