package Assignment2;
import java.util.Scanner;

public class CalendarDisplay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        displayCalendar(month, year);
    }

    public static void displayCalendar(int month, int year) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            daysInMonth[1] = 29; // Adjust for leap year
        }

        int firstDay = dayOfWeek(year, month, 1); // Get the day of the week for the first day of the month

        System.out.println("\n" + months[month - 1] + " " + year);
        System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");

        // Indentation for the first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("\t");
        }

        // Display the days of the month
        for (int i = 1; i <= daysInMonth[month - 1]; i++) {
            System.out.printf("%3d\t", i); // Right-justify single-digit days
            if ((i + firstDay) % 7 == 0) {
                System.out.println(); // Move to the next line after Saturday
            }
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int dayOfWeek(int year, int month, int day) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (day + x + (31 * m0) / 12) % 7;
        return d0; // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
    }
}