package Assignment2;

import java.util.Scanner;

public class code18 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter values for a, b, and c
        System.out.print("Enter the value of a: ");
        int a = input.nextInt();

        System.out.print("Enter the value of b: ");
        int b = input.nextInt();

        System.out.print("Enter the value of c: ");
        int c = input.nextInt();

        // Perform integer operations considering operator precedence
        int result1 = a + b * c; // b * c has higher precedence
        int result2 = a * b + c; // a * b has higher precedence
        int result3 = c + a / b; // a / b has higher precedence
        int result4 = a % b + c; // a % b has higher precedence

        // Output the results
        System.out.printf("The results of Int Operations are %d, %d, and %d\n", result1, result2, result3);

        // Close the scanner
        input.close();
    }
}
