package Assignment2;

import java.util.Scanner;

public class code21 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the temperature in Fahrenheit
        System.out.print("Enter the temperature in Fahrenheit: ");
        double fahrenheit = input.nextDouble();

        // Convert Fahrenheit to Celsius using the formula
        double celsius = (fahrenheit - 32) * 5 / 9;

        // Output the result
        System.out.printf("The %.2f Fahrenheit is %.2f Celsius\n", fahrenheit, celsius);

        // Close the scanner
        input.close();
    }
}
