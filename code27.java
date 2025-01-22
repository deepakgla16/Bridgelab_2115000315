package Assignment2;

import java.util.Scanner;

public class code27 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the Principal, Rate, and Time
        System.out.print("Enter the Principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter the Rate of Interest (in percentage): ");
        double rate = input.nextDouble();

        System.out.print("Enter the Time period (in years): ");
        double time = input.nextDouble();

        // Calculate the Simple Interest
        double simpleInterest = (principal * rate * time) / 100;

        // Output the result
        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f years.\n", 
                          simpleInterest, principal, rate, time);

        // Close the scanner
        input.close();
    }
}
