import java.util.*;

public class PairWithGivenSum {

    // Function to check if there exists a pair with the given sum
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>(); // HashSet to store visited numbers

        for (int num : nums) {
            int complement = target - num; // Find the required complement
            
            if (seen.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true; // Pair found
            }
            
            seen.add(num); // Add current number to the set
        }

        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 1, 8};
        int target = 9;

        if (!hasPairWithSum(nums, target)) {
            System.out.println("No pair found with the given sum.");
        }
    }
}
