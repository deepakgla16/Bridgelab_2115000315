package Assignment2;
import java.util.Scanner;

public class NumberAnalysis {

    // Method to check if the number is positive or negative
    public static boolean isPositive(int number) {
        return number >= 0;
    }

    // Method to check if the number is even or odd
    public static String isEvenOrOdd(int number) {
        if (number % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }

    // Method to compare two numbers and return 1 if number1 > number2,
    // 0 if both are equal, or -1 if number1 < number2
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Array to store the 5 numbers
        int[] numbers = new int[5];

        // Loop to take user input for 5 numbers
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Loop through the array to check if numbers are positive/negative,
        // even/odd, and compare first and last elements
        for (int i = 0; i < 5; i++) {
            int number = numbers[i];
            if (isPositive(number)) {
                System.out.println("Number " + number + " is positive and " + isEvenOrOdd(number) + ".");
            } else {
                System.out.println("Number " + number + " is negative.");
            }
        }

        // Compare the first and last elements of the array
        int comparisonResult = compare(numbers[0], numbers[4]);
        if (comparisonResult == 1) {
            System.out.println("The first number is greater than the last number.");
        } else if (comparisonResult == 0) {
            System.out.println("The first number is equal to the last number.");
        } else {
            System.out.println("The first number is less than the last number.");
        }

        scanner.close();
    }
}
