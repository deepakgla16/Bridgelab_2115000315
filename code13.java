package Assignment2;

import java.util.Scanner;

public class code13 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the perimeter of the square
        System.out.print("Enter the perimeter of the square: ");
        double perimeter = input.nextDouble();

        // Calculate the side of the square (side = perimeter / 4)
        double side = perimeter / 4;

        // Output the result
        System.out.printf("The length of the side is %.2f whose perimeter is %.2f\n", side, perimeter);

        // Close the scanner
        input.close();
    }
}
