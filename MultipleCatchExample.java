import java.util.Scanner;

public class MultipleCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = {10, 20, 30, 40, 50}; // Example array
        // Integer[] numbers = null; // Uncomment to test NullPointerException

        try {
            // Taking user input for index
            System.out.print("Enter index: ");
            int index = scanner.nextInt();

            // Retrieving and printing the value
            System.out.println("Value at index " + index + ": " + numbers[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close(); // Ensure scanner is closed
        }
    }
}
