package Assignment2;
import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Initialize count to 0
        int count = 0;

        // Handle the case for zero
        if (number == 0) {
            count = 1; // Zero has one digit
        } else {
            // Use a loop to count the number of digits
            while (number != 0) {
                number /= 10;  // Remove the last digit from the number
                count++;       // Increment count
            }
        }

        // Display the result
        System.out.println("The number of digits is: " + count);

        scanner.close();
    }
}
