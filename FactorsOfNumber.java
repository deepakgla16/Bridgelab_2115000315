package Assignment2;
import java.util.Scanner;

public class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Display the factors of the number
        System.out.println("The factors of " + number + " are:");
        
        // Loop from 1 to number-1 to find factors
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {  // Check if i is a factor of the number
                System.out.println(i);  // Print the factor
            }
        }

        scanner.close();
    }
}
