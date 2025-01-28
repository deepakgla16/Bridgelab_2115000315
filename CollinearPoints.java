package Assignment2;
import java.util.Scanner;

public class CollinearPoints {

    // Method to check if three points are collinear using the area of the triangle formula
    public static boolean areCollinearUsingArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Calculate the area of the triangle formed by points A(x1, y1), B(x2, y2), and C(x3, y3)
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        
        // Points are collinear if area is 0
        return area == 0;
    }

    // Method to check if three points are collinear using the slope formula
    public static boolean areCollinearUsingSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Calculate slopes of AB, BC, and AC
        double slopeAB = (double)(y2 - y1) / (x2 - x1);
        double slopeBC = (double)(y3 - y2) / (x3 - x2);
        double slopeAC = (double)(y3 - y1) / (x3 - x1);
        
        // Points are collinear if slopeAB == slopeBC == slopeAC
        return slopeAB == slopeBC && slopeAB == slopeAC;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for the coordinates of three points
        System.out.print("Enter x1, y1: ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        System.out.print("Enter x2, y2: ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        System.out.print("Enter x3, y3: ");
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        // Check collinearity using area formula
        boolean collinearArea = areCollinearUsingArea(x1, y1, x2, y2, x3, y3);
        // Check collinearity using slope formula
        boolean collinearSlope = areCollinearUsingSlope(x1, y1, x2, y2, x3, y3);

        // Display results
        if (collinearArea && collinearSlope) {
            System.out.println("The points are collinear.");
        } else {
            System.out.println("The points are not collinear.");
        }
    }
}
