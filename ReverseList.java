import java.util.*;

public class ReverseList {
    // Method to reverse a list without using built-in reverse methods
    public static <T> void reverseList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            // Swap elements at left and right indices
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // Testing with an ArrayList
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original ArrayList: " + arrayList);
        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);
        
        // Testing with a LinkedList
        List<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original LinkedList: " + linkedList);
        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
