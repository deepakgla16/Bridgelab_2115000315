package Assignment2;
import java.util.Scanner;

public class RocketLaunchCountdown2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the starting value for the countdown
        System.out.print("Enter the countdown starting number: ");
        int counter = scanner.nextInt();

        // Countdown using a for loop
        for (int i = counter; i >= 1; i--) {
            System.out.println(i); // Print the current counter value
        }

        // Print the final rocket launch message
        System.out.println("Liftoff! 🚀");

        scanner.close();
    }
}
