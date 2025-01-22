package Assignment2;

import java.util.Scanner;

public class code23 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the first number
        System.out.print("Enter the first number: ");
        int number1 = input.nextInt();

        // Prompt user to enter the second number
        System.out.print("Enter the second number: ");
        int number2 = input.nextInt();

        // Swapping the values of number1 and number2
        int temp = number1;
        number1 = number2;
        number2 = temp;

        // Output the swapped result
        System.out.printf("The swapped numbers are %d and %d\n", number1, number2);

        // Close the scanner
        input.close();
    }
}
