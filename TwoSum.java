import java.util.*;

public class TwoSum {

    // Function to find indices of two numbers that add up to the target sum
    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>(); // Stores number and its index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Find the required complement
            
            // If complement exists in map, return indices
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            
            // Store the current number with its index
            numMap.put(nums[i], i);
        }

        return new int[]{}; // Return empty array if no solution found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = findTwoSum(nums, target);
        
        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found.");
        }
    }
}
