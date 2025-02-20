import java.util.*;

public class ListRotator {
    public static List<Integer> rotateList(List<Integer> list, int positions) {
        int n = list.size();
        positions = positions % n; // Handle cases where positions > list size

        List<Integer> rotatedList = new ArrayList<>();
        rotatedList.addAll(list.subList(positions, n));  // Add elements from index 'positions' to end
        rotatedList.addAll(list.subList(0, positions));  // Add elements from start to 'positions'

        return rotatedList;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        List<Integer> result = rotateList(numbers, rotateBy);
        System.out.println(result);
    }
}
