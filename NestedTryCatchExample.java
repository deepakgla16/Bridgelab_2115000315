import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {10, 20, 30, 40, 50}; // Example array

        try {
            // Taking user input for array index
            System.out.print("Enter array index: ");
            int index = scanner.nextInt();

            try {
                // Attempt to access the array element
                int value = numbers[index];

                // Taking user input for divisor
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();

                // Performing division
                int result = value / divisor;
                System.out.println("Result: " + result);

            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } finally {
            scanner.close(); // Ensure scanner is closed
        }
    }
}
