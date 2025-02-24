import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // Make it available at runtime
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// Step 2: Apply the annotation to a method
class TaskManager {
    
    @TaskInfo(priority = "High", assignedTo = "John Doe")
    public void completeTask() {
        System.out.println("Task is being completed.");
    }
}

// Step 3: Retrieve and display annotation details using Reflection
public class TaskManagerMain {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("completeTask");

        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }

        // Calling the method
        TaskManager taskManager = new TaskManager();
        taskManager.completeTask();
    }
}
