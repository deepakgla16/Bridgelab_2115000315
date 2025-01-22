package Assignment2;

import java.util.Scanner;

public class checkNumberDivisibility{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Check if the number is divisible by 5
        boolean isDivisible = (number % 5 == 0);

        // Output the result
        System.out.printf("Is the number %d divisible by 5? %s\n", number, isDivisible ? "Yes" : "No");

        // Close the scanner
        input.close();
    }
}