package Assignment2;
import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Define arrays to store age and height of 3 friends
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Take input for age and height for each friend
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the age of " + names[i] + ": ");
            ages[i] = scanner.nextInt();

            System.out.print("Enter the height (in cm) of " + names[i] + ": ");
            heights[i] = scanner.nextDouble();
        }

        // Find the youngest friend
        int youngestAge = ages[0];
        String youngestFriend = names[0];
        for (int i = 1; i < 3; i++) {
            if (ages[i] < youngestAge) {
                youngestAge = ages[i];
                youngestFriend = names[i];
            }
        }

        // Find the tallest friend
        double tallestHeight = heights[0];
        String tallestFriend = names[0];
        for (int i = 1; i < 3; i++) {
            if (heights[i] > tallestHeight) {
                tallestHeight = heights[i];
                tallestFriend = names[i];
            }
        }

        // Display the results
        System.out.println("\nThe youngest friend is: " + youngestFriend + " with age " + youngestAge);
        System.out.println("The tallest friend is: " + tallestFriend + " with height " + tallestHeight + " cm");

        // Close the scanner
        scanner.close();
    }
}
