package Assignment2;

import java.util.Scanner;

public class code28 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter weight in pounds
        System.out.print("Enter the weight in pounds: ");
        double weightInPounds = input.nextDouble();

        // Conversion factor
        double conversionFactor = 2.2;

        // Convert weight from pounds to kilograms
        double weightInKg = weightInPounds / conversionFactor;

        // Output the result
        System.out.printf("The weight of the person in pounds is %.2f and in kilograms is %.2f\n", weightInPounds, weightInKg);

        // Close the scanner
        input.close();
    }
}
