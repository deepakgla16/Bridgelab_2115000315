package Assignment2;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Create variables to store the two numbers and the operator
        double first, second, result;
        String op;

        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Get input values from the user
        System.out.print("Enter the first number: ");
        first = scanner.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        op = scanner.next();

        System.out.print("Enter the second number: ");
        second = scanner.nextDouble();

        // Perform the operation based on the operator using a switch-case statement
        switch (op) {
            case "+":
                result = first + second;
                System.out.println("Result: " + first + " + " + second + " = " + result);
                break;

            case "-":
                result = first - second;
                System.out.println("Result: " + first + " - " + second + " = " + result);
                break;

            case "*":
                result = first * second;
                System.out.println("Result: " + first + " * " + second + " = " + result);
                break;

            case "/":
                // Check if the second number is 0 to prevent division by zero
                if (second != 0) {
                    result = first / second;
                    System.out.println("Result: " + first + " / " + second + " = " + result);
                } else {
                    System.out.println("Error: Cannot divide by zero!");
                }
                break;

            default:
                System.out.println("Invalid Operator");
                break;
        }

        // Close the scanner object to prevent memory leak
        scanner.close();
    }
}
