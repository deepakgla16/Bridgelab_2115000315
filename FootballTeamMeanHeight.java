package Assignment2;
import java.util.Scanner;

public class FootballTeamMeanHeight {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Define an array to store the heights of 11 players
        double[] heights = new double[11];

        // Variable to store the sum of heights
        double sum = 0.0;

        // Get input values from the user
        System.out.println("Enter the heights of 11 players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            sum += heights[i]; // Add the height to the sum
        }

        // Calculate the mean height
        double mean = sum / heights.length;

        // Print the mean height
        System.out.printf("\nThe mean height of the football team is: %.2f\n", mean);

        // Close the scanner
        scanner.close();
    }
}
