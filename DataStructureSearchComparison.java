import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000}; // Dataset sizes
        Random random = new Random();

        for (int size : sizes) {
            System.out.println("Dataset Size: " + size);

            // Generate dataset
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                int num = random.nextInt(size * 10); // Random numbers
                array[i] = num;
                hashSet.add(num);
                treeSet.add(num);
            }

            int target = array[size / 2]; // Choose a target element

            // Search in Array (O(N))
            long start = System.nanoTime();
            boolean arrayFound = searchInArray(array, target);
            long arrayTime = System.nanoTime() - start;
            System.out.println("Array Search Time: " + (arrayTime / 1_000_000.0) + " ms");

            // Search in HashSet (O(1) average)
            start = System.nanoTime();
            boolean hashSetFound = hashSet.contains(target);
            long hashSetTime = System.nanoTime() - start;
            System.out.println("HashSet Search Time: " + (hashSetTime / 1_000_000.0) + " ms");

            // Search in TreeSet (O(log N))
            start = System.nanoTime();
            boolean treeSetFound = treeSet.contains(target);
            long treeSetTime = System.nanoTime() - start;
            System.out.println("TreeSet Search Time: " + (treeSetTime / 1_000_000.0) + " ms");

            System.out.println("-----------------------------------");
        }
    }

    // Linear search in an array (O(N))
    private static boolean searchInArray(int[] array, int target) {
        for (int num : array) {
            if (num == target) return true;
        }
        return false;
    }
}
