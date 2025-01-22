package Assignment2;

import java.util.Scanner;

public class code20 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the temperature in Celsius
        System.out.print("Enter the temperature in Celsius: ");
        double celsius = input.nextDouble();

        // Convert Celsius to Fahrenheit using the formula
        double fahrenheit = (celsius * 9/5) + 32;

        // Output the result
        System.out.printf("The %.2f Celsius is %.2f Fahrenheit\n", celsius, fahrenheit);

        // Close the scanner
        input.close();
    }
}
