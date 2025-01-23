package Assignment2;
import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take year input from the user
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        // Check for valid input (year >= 1582)
        if (year >= 1582) {
            // Multiple if-else statements to check leap year conditions
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is not a Leap Year.");
            }

            // A single if statement with multiple logical operators
            if ((year >= 1582) && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is not a Leap Year.");
            }
        } else {
            System.out.println("The year " + year + " is not valid. It should be greater than or equal to 1582.");
        }

        scanner.close();
    }
}
