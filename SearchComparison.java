import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; // Dataset sizes
        Random random = new Random();

        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size * 10); // Random numbers in a wide range
            }

            int target = data[random.nextInt(size)]; // Ensure target is in the dataset

            // Linear Search Timing
            long start = System.nanoTime();
            linearSearch(data, target);
            long linearTime = System.nanoTime() - start;

            // Sorting for Binary Search
            Arrays.sort(data);
            
            // Binary Search Timing
            start = System.nanoTime();
            binarySearch(data, target);
            long binaryTime = System.nanoTime() - start;

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + (linearTime / 1_000_000.0) + " ms");
            System.out.println("Binary Search Time: " + (binaryTime / 1_000_000.0) + " ms");
            System.out.println("-----------------------------------");
        }
    }

    // Linear Search
    private static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search (iterative)
    private static int binarySearch(int[] data, int target) {
        int left = 0, right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) return mid;
            if (data[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
