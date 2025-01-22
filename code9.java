package Assignment2;

import java.util.Scanner;

public class code9 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Take input for fee and discount percentage
        System.out.print("Enter the student fee (INR): ");
        double fee = input.nextDouble();

        System.out.print("Enter the discount percentage: ");
        double discountPercent = input.nextDouble();

        // Calculate discount and discounted fee
        double discount = (fee * discountPercent) / 100;
        double discountedFee = fee - discount;

        // Output the results
        System.out.printf(
            "The discount amount is INR %.2f and final discounted fee is INR %.2f\n",
            discount, discountedFee
        );

        // Close the scanner
        input.close();
    }
}
