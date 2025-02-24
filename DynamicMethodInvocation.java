import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Create an instance of MathOperations
            MathOperations mathOperations = new MathOperations();
            Class<?> clazz = mathOperations.getClass();

            // Take user input for method name
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            // Take user input for two numbers
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Get the method dynamically
            Method method = clazz.getMethod(methodName, int.class, int.class);

            // Invoke the method with user-provided arguments
            int result = (int) method.invoke(mathOperations, num1, num2);

            // Display the result
            System.out.println("Result: " + result);
            
        } catch (NoSuchMethodException e) {
            System.out.println("Error: Method not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
