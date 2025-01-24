package Assignment2;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get the number input from the user
        System.out.print("Enter a number to print its multiplication table: ");
        int number = scanner.nextInt();

        // Define an array to store the multiplication results
        int[] multiplicationTable = new int[10];

        // Calculate and store the multiplication results in the array
        for (int i = 1; i <= 10; i++) {
            multiplicationTable[i - 1] = number * i;
        }

        // Display the multiplication table
        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationTable[i - 1]);
        }

        // Close the scanner
        scanner.close();
    }
}
