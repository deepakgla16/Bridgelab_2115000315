import java.util.*;

public class BinaryNumbersQueue {
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer("1"); // Start with "1"

        for (int i = 0; i < N; i++) {
            String binary = queue.poll();
            result.add(binary);

            // Generate next binary numbers and add to queue
            queue.offer(binary + "0");
            queue.offer(binary + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println(binaryNumbers); // Output: ["1", "10", "11", "100", "101"]
    }
}
