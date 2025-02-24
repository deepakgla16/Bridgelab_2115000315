import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define the @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {}

// Step 2: Create a class with annotated methods
class PerformanceTest {

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Fast method executing...");
    }

    @LogExecutionTime
    public void slowMethod() {
        System.out.println("Slow method executing...");
        try {
            Thread.sleep(500); // Simulating a slow process
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Step 3: Use Reflection to measure execution time for annotated methods
public class PerformanceTestMain {
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(test); // Invoke the method
                long endTime = System.nanoTime();
                
                long executionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds
                System.out.println("Execution time of " + method.getName() + ": " + executionTime + " ms");
                System.out.println("-------------------------------");
            }
        }
    }
}
