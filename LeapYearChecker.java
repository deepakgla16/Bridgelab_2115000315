package Assignment2;
import java.util.Scanner;

public class LeapYearChecker {

    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        // Check if the year is greater than or equal to 1582 (Gregorian calendar)
        if (year < 1582) {
            System.out.println("Year must be 1582 or later.");
            return false;
        }

        // Check if the year is divisible by 4, and not divisible by 100 unless divisible by 400
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;  // It's a leap year
        } else {
            return false; // It's not a leap year
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for the year
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        // Check if the year is a leap year and print the result
        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }

        scanner.close();
    }
}
