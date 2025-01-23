package Assignment2;
import java.util.Scanner;

public class SumOfNaturalNumbers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        // Check if the number is a natural number (greater than or equal to 1)
        if (n >= 1) {
            // Compute the sum using the formula
            int formulaSum = n * (n + 1) / 2;

            // Compute the sum using a for loop
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }

            // Compare the results
            System.out.println("Sum using the formula: " + formulaSum);
            System.out.println("Sum using the for loop: " + loopSum);

            if (formulaSum == loopSum) {
                System.out.println("Both results are correct and match!");
            } else {
                System.out.println("There is a mismatch in the results.");
            }
        } else {
            System.out.println("The number " + n + " is not a natural number.");
        }

        scanner.close();
    }
}
