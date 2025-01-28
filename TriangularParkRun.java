package Assignment2;
import java.util.Scanner;

public class TriangularParkRun {

    // Method to calculate the perimeter of the triangular park
    public static double calculatePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    // Method to calculate the number of rounds needed
    public static int calculateRounds(double perimeter, double distanceToRun) {
        return (int) Math.ceil(distanceToRun / perimeter);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the sides of the triangular park
        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = scanner.nextDouble();

        // Calculate the perimeter of the park
        double perimeter = calculatePerimeter(side1, side2, side3);
        System.out.println("The perimeter of the triangular park is: " + perimeter + " meters");

        // Convert 5 km to meters
        double distanceToRun = 5000; // 5 km = 5000 meters

        // Calculate the number of rounds needed
        int rounds = calculateRounds(perimeter, distanceToRun);
        System.out.println("The athlete needs to complete " + rounds + " rounds to finish a 5 km run.");

        scanner.close();
    }
}
