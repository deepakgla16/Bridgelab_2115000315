import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {}

// Step 2: Create a class with an expensive method
class ExpensiveOperations {

    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeFactorial(int n) {
        if (cache.containsKey(n)) {
            System.out.println("Fetching cached result for: " + n);
            return cache.get(n);
        }
        System.out.println("Computing factorial for: " + n);
        int result = factorial(n);
        cache.put(n, result);
        return result;
    }

    private int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}

// Step 3: Use Reflection to validate caching before invoking method
public class ExpensiveOperationsMain {
    public static void main(String[] args) {
        ExpensiveOperations operations = new ExpensiveOperations();

        // First time - computation happens
        System.out.println("Result: " + executeWithCache(operations, "computeFactorial", 5));

        // Second time - should fetch from cache
        System.out.println("Result: " + executeWithCache(operations, "computeFactorial", 5));

        // New input - computation happens
        System.out.println("Result: " + executeWithCache(operations, "computeFactorial", 6));
    }

    private static int executeWithCache(Object obj, String methodName, int param) {
        try {
            Method method = obj.getClass().getMethod(methodName, int.class);
            if (method.isAnnotationPresent(CacheResult.class)) {
                return (int) method.invoke(obj, param);
            } else {
                System.out.println("Method is not annotated with @CacheResult.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
