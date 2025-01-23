package Assignment2;
import java.util.Scanner;

public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the total to 0.0
        double total = 0.0;

        // Infinite while loop
        while (true) {
            System.out.print("Enter a number (0 or a negative number to stop): ");
            double number = scanner.nextDouble();

            // Check if the number is 0 or negative
            if (number <= 0) {
                break; // Exit the loop
            }

            // Add the number to the total
            total += number;
        }

        // Display the total sum
        System.out.println("The total sum is: " + total);

        scanner.close();
    }
}
