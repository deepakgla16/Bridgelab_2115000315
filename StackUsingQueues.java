import java.util.*;

class StackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push operation (O(1))
    public void push(int x) {
        q1.offer(x);
    }

    // Pop operation (O(n))
    public int pop() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        // Move elements to q2, leaving last element in q1
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int popped = q1.poll(); // This is the last added element (LIFO)

        // Swap q1 and q2 to maintain order
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return popped;
    }

    // Top operation (O(n))
    public int top() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int topElement = q1.peek(); // Get last element
        q2.offer(q1.poll()); // Move last element to q2

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top Element: " + stack.top()); // Output: 3
        System.out.println("Popped: " + stack.pop()); // Output: 3
        System.out.println("Popped: " + stack.pop()); // Output: 2
        System.out.println("Is Stack Empty? " + stack.isEmpty()); // Output: false
    }
}
