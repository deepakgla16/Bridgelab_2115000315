package Assignment2;
import java.util.Scanner;

public class TrigonometricCalculator {

    // Method to calculate the trigonometric functions (sin, cos, tan) for a given angle in degrees
    public static double[] calculateTrigonometricFunctions(double angle) {
        // Convert the angle from degrees to radians
        double radians = Math.toRadians(angle);

        // Calculate sine, cosine, and tangent
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        // Return the results as an array
        return new double[] {sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for the angle in degrees
        System.out.print("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();

        // Calculate the trigonometric functions
        double[] results = calculateTrigonometricFunctions(angle);

        // Display the results
        System.out.printf("Sine of %.2f°: %.4f%n", angle, results[0]);
        System.out.printf("Cosine of %.2f°: %.4f%n", angle, results[1]);
        System.out.printf("Tangent of %.2f°: %.4f%n", angle, results[2]);

        scanner.close();
    }
}
