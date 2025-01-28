package Assignment2;
import java.util.Scanner;

public class EuclideanDistance {

    // Method to calculate the Euclidean distance between two points (x1, y1) and (x2, y2)
    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)); // Euclidean distance formula
    }

    // Method to calculate the slope and y-intercept of the line passing through (x1, y1) and (x2, y2)
    public static double[] calculateLineEquation(double x1, double y1, double x2, double y2) {
        double[] lineEquation = new double[2];

        // Calculate slope (m) of the line
        double m = (y2 - y1) / (x2 - x1);
        lineEquation[0] = m; // Store slope in array

        // Calculate y-intercept (b)
        double b = y1 - m * x1;
        lineEquation[1] = b; // Store y-intercept in array

        return lineEquation;
    }

    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Taking input for two points (x1, y1) and (x2, y2)
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        // Calculate Euclidean distance
        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        System.out.println("Euclidean Distance between the points: " + distance);

        // Calculate line equation (slope and y-intercept)
        double[] lineEquation = calculateLineEquation(x1, y1, x2, y2);
        System.out.println("Equation of the line: y = " + lineEquation[0] + "x + " + lineEquation[1]);
    }
}
