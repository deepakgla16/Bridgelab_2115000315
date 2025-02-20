import java.util.*;

public class SetToSortedList {
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList); // Sort in ascending order
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        List<Integer> sortedList = convertToSortedList(numbers);
        System.out.println(sortedList); // Output: [1, 3, 5, 9]
    }
}
