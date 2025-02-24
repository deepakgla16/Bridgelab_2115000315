import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class ReflectionInvokePrivateMethod {
    public static void main(String[] args) {
        try {
            // Create an instance of Calculator
            Calculator calculator = new Calculator();

            // Get the Class object
            Class<?> clazz = calculator.getClass();

            // Access the private method "multiply"
            Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true); // Allow invocation of private method

            // Invoke the method with arguments (5, 10)
            int result = (int) multiplyMethod.invoke(calculator, 5, 10);

            // Display the result
            System.out.println("Result of multiply(5, 10): " + result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
