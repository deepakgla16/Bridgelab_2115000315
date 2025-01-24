package Assignment2;
import java.util.Scanner;

public class LargestAndSecondLargest2 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Define the array to store the digits and variables
        int maxDigits = 10;
        int[] digits = new int[maxDigits];
        int index = 0;

        // Loop to extract digits from the number and store them in the array
        while (number != 0) {
            // If index equals maxDigits, increase the size of the array
            if (index == maxDigits) {
                // Increase maxDigits by 10
                maxDigits += 10;
                
                // Create a new temp array with the increased size
                int[] temp = new int[maxDigits];
                
                // Copy elements from digits array to temp array
                System.arraycopy(digits, 0, temp, 0, digits.length);
                
                // Reassign digits to temp array
                digits = temp;
            }

            // Add the last digit to the array
            digits[index] = number % 10;
            number = number / 10;  // Remove the last digit
            index++;
        }

        // Variables to store largest and second largest digits
        int largest = -1;
        int secondLargest = -1;

        // Loop to find the largest and second largest digits
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;  // Update second largest
                largest = digits[i];      // Update largest
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];  // Update second largest if not equal to largest
            }
        }

        // Display the largest and second largest numbers
        if (largest != -1 && secondLargest != -1) {
            System.out.println("Largest digit: " + largest);
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("There are not enough digits to find the second largest.");
        }

        // Close the scanner
        scanner.close();
    }
}
