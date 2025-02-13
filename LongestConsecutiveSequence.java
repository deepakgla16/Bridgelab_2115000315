import java.util.*;

public class LongestConsecutiveSequence {
    
    // Function to find the length of the longest consecutive sequence
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num); // Add all numbers to the HashSet
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Check if this is the start of a sequence (no left neighbor)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers in the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        
        int result = longestConsecutive(nums);
        System.out.println("Longest Consecutive Sequence Length: " + result);
    }
}
