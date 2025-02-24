import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define the @Todo annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();         // Description of the task
    String assignedTo();   // Developer responsible
    String priority() default "MEDIUM"; // Default priority is "MEDIUM"
}

// Step 2: Apply the annotation to multiple methods
class Project {

    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void authenticateUser() {
        System.out.println("Authenticating user...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Optimizing database...");
    }

    @Todo(task = "Improve UI responsiveness", assignedTo = "Charlie", priority = "LOW")
    public void improveUI() {
        System.out.println("Improving UI...");
    }

    public void completedFeature() {
        System.out.println("This feature is already implemented.");
    }
}

// Step 3: Retrieve and print all pending tasks using Reflection
public class ProjectMain {
    public static void main(String[] args) {
        Class<Project> clazz = Project.class;

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Pending Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("Method: " + method.getName());
                System.out.println("----------------------------");
            }
        }

        // Testing the methods
        Project project = new Project();
        project.authenticateUser();
        project.optimizeDatabase();
        project.improveUI();
        project.completedFeature();
    }
}
