package Assignment2;

import java.util.Scanner;

public class code12 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the base and height of the triangle
        System.out.print("Enter the base of the triangle (in inches): ");
        double baseInches = input.nextDouble();

        System.out.print("Enter the height of the triangle (in inches): ");
        double heightInches = input.nextDouble();

        // Calculate the area in square inches
        double areaInches = 0.5 * baseInches * heightInches;

        // Convert the area to square centimeters (1 inch = 2.54 cm, so area in cm^2 is (1 inch^2 = 2.54^2 cm^2))
        double areaCm2 = areaInches * (2.54 * 2.54);

        // Output the results
        System.out.printf(
            "The area of the triangle is %.2f square inches and %.2f square centimeters.\n",
            areaInches, areaCm2
        );

        // Close the scanner
        input.close();
    }
}
