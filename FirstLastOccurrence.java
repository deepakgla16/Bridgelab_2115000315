public class FirstLastOccurrence {
    public static int findFirstOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1, first = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevent overflow
            if (nums[mid] == target) {
                first = mid; // Potential first occurrence
                right = mid - 1; // Search on the left
            } else if (nums[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return first;
    }

    public static int findLastOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1, last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevent overflow
            if (nums[mid] == target) {
                last = mid; // Potential last occurrence
                left = mid + 1; // Search on the right
            } else if (nums[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return last;
    }

    public static int[] findFirstAndLast(int[] nums, int target) {
        int first = findFirstOccurrence(nums, target);
        int last = findLastOccurrence(nums, target);
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        
        int[] result = findFirstAndLast(nums, target);
        System.out.println("First Occurrence: " + result[0] + ", Last Occurrence: " + result[1]); 
        // Expected Output: First Occurrence: 1, Last Occurrence: 3

        target = 6;
        result = findFirstAndLast(nums, target);
        System.out.println("First Occurrence: " + result[0] + ", Last Occurrence: " + result[1]); 
        // Expected Output: First Occurrence: -1, Last Occurrence: -1
    }
}
