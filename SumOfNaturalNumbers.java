package Assignment2;
import java.util.Scanner;

public class SumOfNaturalNumbers {

    // Method to calculate the sum of n natural numbers using a loop
    public static int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i; // Add each number from 1 to n
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get integer input from the user
        System.out.print("Enter a positive integer (n): ");
        int n = scanner.nextInt();

        // Validate the input
        if (n < 1) {
            System.out.println("Please enter a positive integer greater than or equal to 1.");
        } else {
            // Call the method to find the sum and display the result
            int sum = findSum(n);
            System.out.println("The sum of the first " + n + " natural numbers is: " + sum);
        }

        scanner.close();
    }
}
