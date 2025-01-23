package Assignment2;
import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the total to 0.0
        double total = 0.0;

        // Variable to store the user input
        double number;

        // Loop until the user enters 0
        do {
            System.out.print("Enter a number (0 to stop): ");
            number = scanner.nextDouble();

            // Add the number to the total if it's not 0
            total += number;
        } while (number != 0);

        // Display the total sum
        System.out.println("The total sum is: " + total);

        scanner.close();
    }
}
