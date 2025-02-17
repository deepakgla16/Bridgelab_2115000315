import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; // Dataset sizes
        Random random = new Random();

        for (int size : sizes) {
            int[] data = new int[size];

            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size * 10); // Random numbers in a wide range
            }

            System.out.println("Dataset Size: " + size);

            // Bubble Sort (Skip for large datasets)
            if (size <= 10000) {
                int[] bubbleData = Arrays.copyOf(data, data.length);
                long start = System.nanoTime();
                bubbleSort(bubbleData);
                long bubbleTime = System.nanoTime() - start;
                System.out.println("Bubble Sort Time: " + (bubbleTime / 1_000_000.0) + " ms");
            } else {
                System.out.println("Bubble Sort: Skipped (Too slow)");
            }

            // Merge Sort
            int[] mergeData = Arrays.copyOf(data, data.length);
            long start = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            long mergeTime = System.nanoTime() - start;
            System.out.println("Merge Sort Time: " + (mergeTime / 1_000_000.0) + " ms");

            // Quick Sort
            int[] quickData = Arrays.copyOf(data, data.length);
            start = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            long quickTime = System.nanoTime() - start;
            System.out.println("Quick Sort Time: " + (quickTime / 1_000_000.0) + " ms");

            System.out.println("-----------------------------------");
        }
    }

    // Bubble Sort (O(N²))
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: Stop if already sorted
        }
    }

    // Merge Sort (O(N log N))
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // Quick Sort (O(N log N))
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Last element as pivot
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
