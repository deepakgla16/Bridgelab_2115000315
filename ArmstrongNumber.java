package Assignment2;
import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Initialize sum and store the original number
        int sum = 0;
        int originalNumber = number;

        // Loop to extract each digit and compute the sum of cubes
        while (number != 0) {
            int digit = number % 10;  // Extract the last digit
            sum += Math.pow(digit, 3);  // Cube the digit and add it to sum
            number /= 10;  // Remove the last digit
        }

        // Check if the sum of cubes is equal to the original number
        if (sum == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }

        scanner.close();
    }
}
