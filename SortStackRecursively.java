import java.util.Stack;

public class SortStackRecursively {
    
    // Function to sort a stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop(); // Remove the top element
            sortStack(stack); // Sort the remaining stack
            insertInSortedOrder(stack, top); // Insert the popped element at the correct position
        }
    }

    // Helper function to insert an element in a sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element); // Insert when stack is empty or top is smaller/equal
        } else {
            int top = stack.pop(); // Remove the top
            insertInSortedOrder(stack, element); // Recursively insert in sorted order
            stack.push(top); // Push the original top back
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);

        System.out.println("Original Stack: " + stack);
        
        sortStack(stack);
        
        System.out.println("Sorted Stack: " + stack);
    }
}
