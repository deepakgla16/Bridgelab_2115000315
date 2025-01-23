package Assignment2;
import java.util.Scanner;

public class AbundantNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Initialize sum to 0
        int sum = 0;

        // Find divisors and calculate the sum
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {  // Check if i is a divisor of number
                sum += i;            // Add the divisor to sum
            }
        }

        // Check if the sum of divisors is greater than the number
        if (sum > number) {
            System.out.println(number + " is an Abundant number.");
        } else {
            System.out.println(number + " is not an Abundant number.");
        }

        scanner.close();
    }
}
