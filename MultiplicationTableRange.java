package Assignment2;
import java.util.Scanner;

public class MultiplicationTableRange {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get the number input from the user
        System.out.print("Enter a number to display its multiplication table from 6 to 9: ");
        int number = scanner.nextInt();

        // Define an array to store the multiplication results
        int[] multiplicationResult = new int[4];

        // Calculate and store the multiplication results in the array
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }

        // Display the multiplication table
        System.out.println("\nMultiplication Table of " + number + " (from 6 to 9):");
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
        }

        // Close the scanner
        scanner.close();
    }
}
