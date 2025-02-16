import java.util.Arrays;

public class SearchChallenge {

    // Linear Search: Find the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number at its correct index if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // Step 2: Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // First missing positive
            }
        }

        return n + 1; // If no missing number is found
    }

    // Swap function
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Binary Search: Find the index of a target number in a sorted array
    public static int binarySearch(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: Sort the array before binary search
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevent overflow

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;

        // Finding the first missing positive integer
        int missingPositive = findFirstMissingPositive(nums);
        System.out.println("First Missing Positive: " + missingPositive); 
        // Expected Output: 2

        // Performing Binary Search
        int targetIndex = binarySearch(nums, target);
        System.out.println("Target Index after sorting: " + targetIndex);
        // Expected Output: (depends on sorting, might be different)
    }
}
