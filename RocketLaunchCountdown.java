package Assignment2;
import java.util.Scanner;

public class RocketLaunchCountdown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the starting value for the countdown
        System.out.print("Enter the countdown starting number: ");
        int counter = scanner.nextInt();

        // Countdown using a while loop
        while (counter >= 1) {
            System.out.println(counter); // Print the current counter value
            counter--; // Decrement the counter
        }

        // Print the final rocket launch message
        System.out.println("Liftoff! 🚀");

        scanner.close();
    }
}
