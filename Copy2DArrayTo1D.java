package Assignment2;
import java.util.Scanner;

public class Copy2DArrayTo1D {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get user input for the number of rows and columns
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        // Create a 2D array (Matrix)
        int[][] matrix = new int[rows][columns];

        // Take user input for the 2D array elements
        System.out.println("\nEnter the elements of the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element for position [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Create a 1D array to store the elements of the 2D array
        int[] array = new int[rows * columns];
        int index = 0;

        // Copy elements from the 2D array to the 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index++] = matrix[i][j];
            }
        }

        // Display the 1D array
        System.out.println("\nElements of the 1D array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // Close the scanner
        scanner.close();
    }
}
