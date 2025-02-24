import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define the @ImportantMethod annotation
@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH"; // Optional parameter with default value
}

// Step 2: Apply the annotation to methods
class Application {

    @ImportantMethod(level = "CRITICAL")
    public void start() {
        System.out.println("Application is starting...");
    }

    @ImportantMethod // Uses default level "HIGH"
    public void stop() {
        System.out.println("Application is stopping...");
    }

    public void helper() {
        System.out.println("Helper method, not marked as important.");
    }
}

// Step 3: Retrieve and print annotated methods using Reflection API
public class ApplicationMain {
    public static void main(String[] args) {
        Class<Application> clazz = Application.class;

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName() + ", Level: " + annotation.level());
            }
        }

        // Testing the methods
        Application app = new Application();
        app.start();
        app.stop();
        app.helper();
    }
}
