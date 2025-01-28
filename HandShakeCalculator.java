package Assignment2;
import java.util.Scanner;

public class HandShakeCalculator {

    // Method to calculate the maximum number of handshakes using the combination formula
    public static int calculateHandshakes(int n) {
        if (n < 2) {
            return 0; // No handshakes possible with fewer than 2 students
        }
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of students as input
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        // Calculate and display the maximum number of handshakes
        int maxHandshakes = calculateHandshakes(numberOfStudents);
        System.out.println("The maximum number of handshakes is: " + maxHandshakes);

        scanner.close();
    }
}
