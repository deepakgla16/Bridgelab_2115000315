import java.util.*;

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer num : list) {
            if (seen.add(num)) { // Only add if it's not already in the set
                result.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> uniqueList = removeDuplicates(numbers);
        System.out.println(uniqueList);
    }
}
