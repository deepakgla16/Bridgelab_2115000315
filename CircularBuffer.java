import java.util.Arrays;

class CircularBuffer {
    private int[] buffer;
    private int size, front, rear, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    // Insert element, overwriting oldest if full
    public void enqueue(int value) {
        rear = (rear + 1) % capacity; // Circular increment
        buffer[rear] = value;

        if (size < capacity) {
            size++; // Increase size until full
        } else {
            front = (front + 1) % capacity; // Overwrite oldest element
        }
    }

    // Retrieve elements in buffer order
    public int[] getBufferContents() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[(front + i) % capacity];
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
        System.out.println("Buffer: " + Arrays.toString(cb.getBufferContents())); // [1, 2, 3]

        cb.enqueue(4); // Overwrites oldest (1)
        System.out.println("Buffer: " + Arrays.toString(cb.getBufferContents())); // [2, 3, 4]

        cb.enqueue(5); // Overwrites 2
        System.out.println("Buffer: " + Arrays.toString(cb.getBufferContents())); // [3, 4, 5]
    }
}
