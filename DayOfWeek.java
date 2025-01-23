package Assignment2;
import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        // Check if the correct number of command-line arguments are provided
        if (args.length != 3) {
            System.out.println("Please provide month, day, and year as command-line arguments.");
            return;
        }

        // Parse the command-line arguments into integers
        int m = Integer.parseInt(args[0]);  // Month
        int d = Integer.parseInt(args[1]);  // Day
        int y = Integer.parseInt(args[2]);  // Year

        // Calculate y0, x, m0, and d0 using the provided formulas
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + 31 * m0 / 12) % 7;

        // Print the result: 0 for Sunday, 1 for Monday, 2 for Tuesday, etc.
        System.out.println("Day of the week: " + d0);
    }
}
