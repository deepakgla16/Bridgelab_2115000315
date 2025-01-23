package Assignment2;
import java.util.Scanner;

public class Factorial2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check if the number is a positive integer
        if (number >= 0) {
            // Compute factorial using a for loop
            int factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i; // Multiply factorial by i
            }

            // Output the result
            System.out.println("The factorial of " + number + " is: " + factorial);
        } else {
            System.out.println("The number " + number + " is not a positive integer.");
        }

        scanner.close();
    }
}
