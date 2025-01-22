package Assignment2;

import java.util.Scanner;

public class code19 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter values for a, b, and c as doubles
        System.out.print("Enter the value of a (double): ");
        double a = input.nextDouble();

        System.out.print("Enter the value of b (double): ");
        double b = input.nextDouble();

        System.out.print("Enter the value of c (double): ");
        double c = input.nextDouble();

        // Perform double operations considering operator precedence
        double result1 = a + b * c; // b * c has higher precedence
        double result2 = a * b + c; // a * b has higher precedence
        double result3 = c + a / b; // a / b has higher precedence
        double result4 = a % b + c; // a % b has higher precedence

        // Output the results
        System.out.printf("The results of Double Operations are %.2f, %.2f, and %.2f\n", result1, result2, result3);

        // Close the scanner
        input.close();
    }
}
