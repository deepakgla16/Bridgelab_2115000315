package Assignment2;
import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();  // To handle large numbers
        
        // Create an array to store the frequency of each digit (0-9)
        int[] frequency = new int[10];

        // Convert the number into digits and store the frequency
        while (number > 0) {
            int digit = (int)(number % 10);  // Extract the last digit
            frequency[digit]++;  // Increase the frequency count for the digit
            number /= 10;  // Remove the last digit from the number
        }

        // Display the frequency of each digit
        System.out.println("Frequency of each digit:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i]);
            }
        }

        // Close the scanner
        scanner.close();
    }
}
