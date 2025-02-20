import java.util.*;

public class ReverseQueue {
    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Dequeue all elements and push them onto a stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Step 2: Pop elements from the stack and enqueue them back
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        return queue; // The queue is now reversed
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));

        System.out.println("Original Queue: " + queue);
        queue = reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}
