package Assignment2;
import java.util.Scanner;

public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Display the multiples of the number below 100
        System.out.println("Multiples of " + number + " below 100 are:");

        // Loop backward from 100 to 1 to check for multiples
        for (int i = 100; i >= 1; i--) {
            if (i % number == 0) {  // Check if i is divisible by the input number
                System.out.println(i);  // Print the multiple
            }
        }

        scanner.close();
    }
}
