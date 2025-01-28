package Assignment2;
import java.util.Scanner;

public class QuadraticEquation {

    // Method to find the roots of the quadratic equation ax^2 + bx + c = 0
    public static double[] findRoots(int a, int b, int c) {
        // Calculate the delta (discriminant)
        double delta = Math.pow(b, 2) - 4 * a * c;
        double[] roots = new double[0]; // Default empty array for no roots

        if (delta > 0) {
            // Two real and distinct roots
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            roots = new double[]{root1, root2}; // Store the two roots in the array
        } else if (delta == 0) {
            // One real root
            double root = -b / (2.0 * a);
            roots = new double[]{root}; // Store the single root in the array
        }
        // If delta < 0, no real roots are returned (empty array is used)
        return roots;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for a, b, and c
        System.out.print("Enter value of a: ");
        int a = scanner.nextInt();
        System.out.print("Enter value of b: ");
        int b = scanner.nextInt();
        System.out.print("Enter value of c: ");
        int c = scanner.nextInt();

        // Find the roots using the method
        double[] roots = findRoots(a, b, c);

        // Display the results
        if (roots.length == 0) {
            System.out.println("No real roots exist.");
        } else if (roots.length == 1) {
            System.out.println("The root is: " + roots[0]);
        } else {
            System.out.println("The roots are: " + roots[0] + " and " + roots[1]);
        }

        scanner.close();
    }
}
