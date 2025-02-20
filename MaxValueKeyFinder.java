import java.util.*;

public class MaxValueKeyFinder {
    public static String findMaxValueKey(Map<String, Integer> inputMap) {
        if (inputMap.isEmpty()) {
            return null; // Handle empty map case
        }

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    public static void main(String[] args) {
        // Sample input
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        // Find key with the highest value
        String maxKey = findMaxValueKey(inputMap);

        // Print output
        System.out.println("Key with highest value: " + maxKey);
    }
}
