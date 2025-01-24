package Assignment2;
import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Define an integer array of 5 elements
        int[] numbers = new int[5];

        // Get user input to store in the array
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Analyze each number in the array
        System.out.println("\nNumber analysis:");
        for (int number : numbers) {
            if (number > 0) {
                if (number % 2 == 0) {
                    System.out.println(number + " is positive and even.");
                } else {
                    System.out.println(number + " is positive and odd.");
                }
            } else if (number < 0) {
                System.out.println(number + " is negative.");
            } else {
                System.out.println(number + " is zero.");
            }
        }

        // Compare the first and last elements of the array
        System.out.println("\nComparison of the first and last elements:");
        if (numbers[0] > numbers[4]) {
            System.out.println("The first element (" + numbers[0] + ") is greater than the last element (" + numbers[4] + ").");
        } else if (numbers[0] < numbers[4]) {
            System.out.println("The first element (" + numbers[0] + ") is less than the last element (" + numbers[4] + ").");
        } else {
            System.out.println("The first element (" + numbers[0] + ") is equal to the last element (" + numbers[4] + ").");
        }

        // Close the scanner
        scanner.close();
    }
}
