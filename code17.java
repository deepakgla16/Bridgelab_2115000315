package Assignment2;

import java.util.Scanner;

public class code17 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the first number
        System.out.print("Enter the first number: ");
        int number1 = input.nextInt();

        // Prompt user to enter the second number
        System.out.print("Enter the second number: ");
        int number2 = input.nextInt();

        // Calculate the quotient and remainder
        int quotient = number1 / number2;
        int remainder = number1 % number2;

        // Output the result
        System.out.printf("The Quotient is %d and Remainder is %d of two numbers %d and %d\n", 
                          quotient, remainder, number1, number2);

        // Close the scanner
        input.close();
    }
}
