import java.util.Stack;
import java.util.NoSuchElementException;

public class QueueUsingStacks<T> {
    private Stack<T> stackEnqueue; // Stack for enqueue operations
    private Stack<T> stackDequeue; // Stack for dequeue operations

    public QueueUsingStacks() {
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }

    // Enqueue operation (O(1))
    public void enqueue(T value) {
        stackEnqueue.push(value);
    }

    // Dequeue operation (Amortized O(1), worst case O(n))
    public T dequeue() {
        if (stackDequeue.isEmpty()) {
            if (stackEnqueue.isEmpty()) {
                throw new NoSuchElementException("Queue Underflow");
            }
            // Transfer elements from stackEnqueue to stackDequeue
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.pop();
    }

    // Peek operation (O(1) amortized)
    public T peek() {
        if (stackDequeue.isEmpty()) {
            if (stackEnqueue.isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            // Transfer elements before peeking
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.peek();
    }

    // Check if the queue is empty (O(1))
    public boolean isEmpty() {
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        System.out.println("Front element: " + queue.peek()); // Should print 1
        System.out.println("Dequeue: " + queue.dequeue()); // Removes 1
        System.out.println("Dequeue: " + queue.dequeue()); // Removes 2
        
        queue.enqueue(4);
        
        System.out.println("Front element: " + queue.peek()); // Should print 3
        System.out.println("Dequeue: " + queue.dequeue()); // Removes 3
        System.out.println("Dequeue: " + queue.dequeue()); // Removes 4
        
        System.out.println("Is queue empty? " + queue.isEmpty()); // Should print true
    }
}
