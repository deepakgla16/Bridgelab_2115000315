package Assignment2;
import java.util.Scanner;

public class ArrayInputSum {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Define an array to store up to 10 elements of type double
        double[] numbers = new double[10];

        // Variables to keep track of the total and the index
        double total = 0.0;
        int index = 0;

        // Infinite loop to collect user input
        System.out.println("Enter up to 10 numbers (enter 0 or a negative number to stop):");
        while (true) {
            // Take user input
            System.out.print("Enter a number: ");
            double input = scanner.nextDouble();

            // Break the loop if the user enters 0 or a negative number
            if (input <= 0) {
                break;
            }

            // Store the input in the array and increment the index
            numbers[index] = input;
            index++;

            // Break the loop if the array is full (index reaches 10)
            if (index == 10) {
                break;
            }
        }

        // Display the numbers and calculate the total
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i];
        }

        // Display the total
        System.out.println("\n\nSum of all numbers: " + total);

        // Close the scanner
        scanner.close();
    }
}
