package Assignment2;
import java.util.Scanner;

public class code11 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter two numbers
        System.out.print("Enter the first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        double number2 = input.nextDouble();

        // Perform arithmetic operations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = (number2 != 0) ? number1 / number2 : Double.NaN; // Check division by zero

        // Output the results
        System.out.printf(
            "The addition, subtraction, multiplication, and division value of %.2f and %.2f is %.2f, %.2f, %.2f, and %.2f\n",
            number1, number2, addition, subtraction, multiplication, division
        );

        // Close the scanner
        input.close();
    }
}
