package Assignment2;

import java.util.Scanner;

public class code10 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter height in centimeters
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();

        // Conversion factors
        double cmToInches = 2.54;
        double inchesToFeet = 12;

        // Convert height to inches
        double totalInches = heightCm / cmToInches;

        // Convert inches to feet and remaining inches
        int feet = (int) (totalInches / inchesToFeet); // Get the integer part for feet
        double inches = totalInches % inchesToFeet; // Get the remainder for inches

        // Output the result
        System.out.printf(
            "Your Height in cm is %.2f while in feet is %d and inches is %.2f\n",
            heightCm, feet, inches
        );

        // Close the scanner
        input.close();
    }
}
