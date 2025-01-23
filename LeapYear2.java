package Assignment2;
import java.util.Scanner;

public class LeapYear2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take year input from the user
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        // Check for valid year >= 1582 and determine if it's a Leap Year using a single if condition
        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println(year + " is a Leap Year.");
        } else if (year >= 1582) {
            System.out.println(year + " is not a Leap Year.");
        } else {
            System.out.println("The year " + year + " is not valid. It should be greater than or equal to 1582.");
        }

        scanner.close();
    }
}
