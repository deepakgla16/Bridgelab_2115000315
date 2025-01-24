package Assignment2;
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take the number input from the user
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check if the number is positive
        if (number <= 0) {
            System.out.println("Error: Please enter a positive integer.");
            return;
        }

        // Create a String array to save the results
        String[] results = new String[number + 1];

        // Loop from 0 to the given number and apply the FizzBuzz logic
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz"; // Multiple of both 3 and 5
            } else if (i % 3 == 0) {
                results[i] = "Fizz"; // Multiple of 3
            } else if (i % 5 == 0) {
                results[i] = "Buzz"; // Multiple of 5
            } else {
                results[i] = Integer.toString(i); // Otherwise, store the number itself
            }
        }

        // Display the results
        System.out.println("\nFizzBuzz results:");
        for (int i = 0; i <= number; i++) {
            System.out.println("Position " + (i + 1) + " = " + results[i]);
        }

        // Close the scanner
        scanner.close();
    }
}
