public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; // Number of concatenations

        for (int size : sizes) {
            System.out.println("Operations Count: " + size);

            // Using String (Inefficient)
            long start = System.nanoTime();
            concatenateWithString(size);
            long stringTime = System.nanoTime() - start;
            System.out.println("String Time: " + (stringTime / 1_000_000.0) + " ms");

            // Using StringBuilder (Fast)
            start = System.nanoTime();
            concatenateWithStringBuilder(size);
            long stringBuilderTime = System.nanoTime() - start;
            System.out.println("StringBuilder Time: " + (stringBuilderTime / 1_000_000.0) + " ms");

            // Using StringBuffer (Thread-Safe)
            start = System.nanoTime();
            concatenateWithStringBuffer(size);
            long stringBufferTime = System.nanoTime() - start;
            System.out.println("StringBuffer Time: " + (stringBufferTime / 1_000_000.0) + " ms");

            System.out.println("-----------------------------------");
        }
    }

    // String concatenation (O(N²), very slow for large N)
    private static void concatenateWithString(int size) {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += "A"; // Creates new String object each time
        }
    }

    // StringBuilder concatenation (O(N), much faster)
    private static void concatenateWithStringBuilder(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("A");
        }
    }

    // StringBuffer concatenation (O(N), thread-safe, slightly slower than StringBuilder)
    private static void concatenateWithStringBuffer(int size) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append("A");
        }
    }
}
