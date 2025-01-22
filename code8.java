package Assignment2;

import java.util.Scanner;

public class code8 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter distance in kilometers
        System.out.print("Enter the distance in kilometers: ");
        double km = input.nextDouble();

        // Conversion factor (1 mile = 1.6 km)
        double miles = km / 1.6;

        // Output the result
        System.out.printf("The total miles is %.2f miles for the given %.2f km\n", miles, km);

        // Close the scanner
        input.close();
    }
}
