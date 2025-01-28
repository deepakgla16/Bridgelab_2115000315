package Assignment2;
import java.util.Scanner;

public class NaturalNumberSum {

    // Method to calculate the sum of n natural numbers using recursion
    public static int sumUsingRecursion(int n) {
        if (n == 1) {
            return 1;  // Base case: sum of first 1 natural number is 1
        }
        return n + sumUsingRecursion(n - 1);  // Recursive case
    }

    // Method to calculate the sum of n natural numbers using the formula n * (n + 1) / 2
    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the number n
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        // Check if the number is a natural number (positive integer)
        if (n <= 0) {
            System.out.println("Please enter a valid natural number greater than 0.");
            return;
        }

        // Calculate the sum using both methods
        int sumRecursion = sumUsingRecursion(n);
        int sumFormula = sumUsingFormula(n);

        // Compare the results and print them
        System.out.println("Sum using recursion: " + sumRecursion);
        System.out.println("Sum using formula: " + sumFormula);

        // Check if both results are the same
        if (sumRecursion == sumFormula) {
            System.out.println("Both methods give the correct result.");
        } else {
            System.out.println("There is a discrepancy between the methods.");
        }

        scanner.close();
    }
}
