package Assignment2;

import java.util.Scanner;

public class code25 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the sides of the triangular park
        System.out.print("Enter the length of side1 in meters: ");
        double side1 = input.nextDouble();

        System.out.print("Enter the length of side2 in meters: ");
        double side2 = input.nextDouble();

        System.out.print("Enter the length of side3 in meters: ");
        double side3 = input.nextDouble();

        // Calculate the perimeter of the triangle (sum of all sides)
        double perimeter = side1 + side2 + side3;

        // Convert 5 km to meters (5000 meters)
        double totalDistance = 5000;

        // Calculate the number of rounds required to cover the total distance
        double rounds = totalDistance / perimeter;

        // Output the result
        System.out.printf("The total number of rounds the athlete will run to complete 5 km is %.2f\n", rounds);

        // Close the scanner
        input.close();
    }
}
