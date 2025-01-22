package Assignment2;

import java.util.Scanner;

public class code14 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the distance in feet
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = input.nextDouble();

        // Conversion factors
        double feetToYards = 1.0 / 3;  // 1 yard = 3 feet
        double feetToMiles = 1.0 / (3 * 1760); // 1 mile = 1760 yards and 1 yard = 3 feet

        // Convert distance to yards and miles
        double distanceInYards = distanceInFeet * feetToYards;
        double distanceInMiles = distanceInFeet * feetToMiles;

        // Output the results
        System.out.printf(
            "The distance is %.2f feet, which is %.2f yards and %.2f miles.\n",
            distanceInFeet, distanceInYards, distanceInMiles
        );

        // Close the scanner
        input.close();
    }
}
