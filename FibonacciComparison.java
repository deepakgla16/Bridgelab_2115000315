public class FibonacciComparison {
    public static void main(String[] args) {
        int[] testCases = {10, 30, 50}; // Fibonacci numbers to compute

        for (int n : testCases) {
            System.out.println("Fibonacci(" + n + ")");

            // Recursive Fibonacci (Exponential Time Complexity)
            if (n <= 30) { // Limit recursion to avoid long execution time
                long start = System.nanoTime();
                int fibRecursive = fibonacciRecursive(n);
                long recursiveTime = System.nanoTime() - start;
                System.out.println("Recursive Result: " + fibRecursive);
                System.out.println("Recursive Time: " + (recursiveTime / 1_000_000.0) + " ms");
            } else {
                System.out.println("Recursive: Skipped (Too slow)");
            }

            // Iterative Fibonacci (Linear Time Complexity)
            long start = System.nanoTime();
            int fibIterative = fibonacciIterative(n);
            long iterativeTime = System.nanoTime() - start;
            System.out.println("Iterative Result: " + fibIterative);
            System.out.println("Iterative Time: " + (iterativeTime / 1_000_000.0) + " ms");

            System.out.println("-----------------------------------");
        }
    }

    // Recursive Fibonacci (O(2^N) - Extremely slow for large N)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(N) - Fast and memory efficient)
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
