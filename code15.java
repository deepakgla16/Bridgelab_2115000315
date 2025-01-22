package Assignment2;

import java.util.Scanner;

public class code15 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the unit price and quantity
        System.out.print("Enter the unit price of the item: ");
        double unitPrice = input.nextDouble();

        System.out.print("Enter the quantity to be bought: ");
        int quantity = input.nextInt();

        // Calculate the total price
        double totalPrice = unitPrice * quantity;

        // Output the result
        System.out.printf(
            "The total purchase price is INR %.2f if the quantity is %d and unit price is INR %.2f\n",
            totalPrice, quantity, unitPrice
        );

        // Close the scanner
        input.close();
    }
}
