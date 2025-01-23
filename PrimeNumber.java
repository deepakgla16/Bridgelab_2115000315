package Assignment2;
import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Boolean variable to store the result
        boolean isPrime = true;

        // Check if number is greater than 1
        if (number <= 1) {
            isPrime = false;  // Numbers less than or equal to 1 are not prime
        } else {
            // Loop from 2 to number-1 and check if any number divides the input number
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false; // Number is divisible by i, so it's not prime
                    break; // Exit the loop as the number is already determined to be not prime
                }
            }
        }

        // Output result based on the isPrime variable
        if (isPrime) {
            System.out.println(number + " is a Prime Number.");
        } else {
            System.out.println(number + " is not a Prime Number.");
        }

        scanner.close();
    }
}
