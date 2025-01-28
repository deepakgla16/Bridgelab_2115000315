package Assignment2;
import java.util.Scanner;

public class ChocolateDistribution {

    // Method to find the quotient (chocolates per child) and remainder (remaining chocolates)
    public static int[] findRemainderAndQuotient(int numberOfChocolates, int numberOfChildren) {
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;
        return new int[] {chocolatesPerChild, remainingChocolates};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for the number of chocolates
        System.out.print("Enter the total number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        // Get input for the number of children
        System.out.print("Enter the total number of children: ");
        int numberOfChildren = scanner.nextInt();

        // Validate input to avoid division by zero
        if (numberOfChildren == 0) {
            System.out.println("Number of children cannot be zero. Please enter a valid number.");
        } else {
            // Call the method and get the result
            int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

            // Display the result
            System.out.println("Each child will get " + result[0] + " chocolates.");
            System.out.println("Remaining chocolates: " + result[1]);
        }

        scanner.close();
    }
}
