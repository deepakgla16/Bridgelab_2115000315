package Assignment2;
import java.util.Scanner;

public class QuotientAndRemainder {

    // Method to find the quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[] {quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for two numbers
        System.out.print("Enter the dividend (number): ");
        int number = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // Validate divisor to avoid division by zero
        if (divisor == 0) {
            System.out.println("Divisor cannot be zero. Please enter a valid divisor.");
        } else {
            // Call the method and get the result
            int[] result = findRemainderAndQuotient(number, divisor);

            // Display the quotient and remainder
            System.out.println("Quotient: " + result[0]);
            System.out.println("Remainder: " + result[1]);
        }

        scanner.close();
    }
}
