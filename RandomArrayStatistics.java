package Assignment2;
import java.util.Random;

public class RandomArrayStatistics {

    // Method to generate an array of 4-digit random numbers given the size
    public static int[] generate4DigitRandomArray(int size) {
        Random random = new Random();
        int[] numbers = new int[size];

        // Generate random 4-digit numbers and store them in the array
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(9000) + 1000; // Generate number between 1000 and 9999
        }

        return numbers;
    }

    // Method to find the average, minimum, and maximum value of an array
    public static double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        // Iterate through the array to calculate sum, min, and max
        for (int num : numbers) {
            sum += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }

        double average = sum / numbers.length;

        // Return the results in an array [average, min, max]
        return new double[]{average, min, max};
    }

    public static void main(String[] args) {
        int size = 10; // Example size of the array
        int[] randomNumbers = generate4DigitRandomArray(size);

        // Print the generated random numbers
        System.out.println("Generated 4-digit random numbers:");
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Find average, min, and max
        double[] results = findAverageMinMax(randomNumbers);
        System.out.println("Average: " + results[0]);
        System.out.println("Minimum: " + results[1]);
        System.out.println("Maximum: " + results[2]);
    }
}
