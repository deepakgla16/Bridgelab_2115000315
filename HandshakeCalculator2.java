package Assignment2;
import java.util.Scanner;

public class HandshakeCalculator2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get integer input for numberOfStudents
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        // Calculate the maximum number of handshakes using the formula
        int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        // Display the number of possible handshakes
        System.out.println("The maximum number of possible handshakes is: " + maxHandshakes);

        scanner.close();
    }
}
