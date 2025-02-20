import java.util.*;

public class SymmetricDifference {
    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2); // Union of both sets

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // Intersection of both sets

        result.removeAll(intersection); // Remove common elements to get symmetric difference

        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2)); 
        // Output: {1, 2, 4, 5}
    }
}
