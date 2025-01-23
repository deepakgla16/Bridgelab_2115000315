package Assignment2;
import java.util.Scanner;

public class FizzBuzz2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take number input from the user
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check if the number is a positive integer
        if (number > 0) {
            int i = 1;  // Start the counter from 1

            // While loop to iterate from 1 to the entered number
            while (i <= number) {
                // Check if the number is divisible by both 3 and 5
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                }
                // Check if the number is divisible by 3
                else if (i % 3 == 0) {
                    System.out.println("Fizz");
                }
                // Check if the number is divisible by 5
                else if (i % 5 == 0) {
                    System.out.println("Buzz");
                }
                // Otherwise, print the number itself
                else {
                    System.out.println(i);
                }
                i++;  // Increment the counter
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }

        scanner.close();
    }
}
