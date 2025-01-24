package Assignment2;
import java.util.Scanner;

public class FindFactors {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a positive integer to find its factors: ");
        int number = scanner.nextInt();

        // Validate input for a positive integer
        if (number <= 0) {
            System.out.println("Error: Please enter a positive integer.");
            return;
        }

        // Initialize variables
        int maxFactor = 10; // Initial size of the factors array
        int[] factors = new int[maxFactor];
        int index = 0; // Index to keep track of the number of factors

        // Find factors and store them in the array
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // If the array is full, resize it
                if (index == maxFactor) {
                    maxFactor *= 2; // Double the size
                    int[] temp = new int[maxFactor];
                    System.arraycopy(factors, 0, temp, 0, factors.length);
                    factors = temp;
                }
                // Add the factor to the array
                factors[index++] = i;
            }
        }

        // Display the factors
        System.out.println("\nFactors of " + number + ":");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        // Close the scanner
        scanner.close();
    }
}
