package Assignment2;
import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Define the greatestFactor variable and initialize it to 1
        int greatestFactor = 1;

        // Loop from number - 1 to 1 to find the greatest factor
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {  // Check if i is a divisor of the number
                greatestFactor = i;
                break;  // Exit the loop as we found the greatest factor
            }
        }

        // Display the greatest factor
        System.out.println("The greatest factor of " + number + " (beside itself) is: " + greatestFactor);

        scanner.close();
    }
}
