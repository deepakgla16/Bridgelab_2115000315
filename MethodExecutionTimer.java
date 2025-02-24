import java.lang.reflect.Method;

// Step 1: Define a Sample Class with Methods to Measure Execution Time
class SampleOperations {
    public void fastMethod() {
        System.out.println("Executing fastMethod...");
    }

    public void slowMethod() {
        System.out.println("Executing slowMethod...");
        try {
            Thread.sleep(1000); // Simulate a slow operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Step 2: Create a Utility to Measure Execution Time Using Reflection
public class MethodExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName); // Get the method by name
            long startTime = System.nanoTime(); // Start timing
            method.invoke(obj); // Invoke the method dynamically
            long endTime = System.nanoTime(); // End timing

            long executionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds
            System.out.println("Execution time of " + methodName + ": " + executionTime + " ms");
        } catch (Exception e) {
            System.err.println("Error executing method: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SampleOperations obj = new SampleOperations();

        // Measure execution time for different methods
        measureExecutionTime(obj, "fastMethod");
        measureExecutionTime(obj, "slowMethod");
    }
}
