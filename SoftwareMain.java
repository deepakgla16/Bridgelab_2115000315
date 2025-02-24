import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define the container annotation
@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

// Step 2: Define the repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// Step 3: Apply the repeatable annotation to a method
class Software {
    
    @BugReport(description = "NullPointerException occurs on null input")
    @BugReport(description = "Performance issue when processing large data")
    public void process() {
        System.out.println("Processing data...");
    }
}

// Step 4: Retrieve and print all bug reports using Reflection
public class SoftwareMain {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("process");

        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug Report: " + bug.description());
            }
        }

        // Calling the method
        Software software = new Software();
        software.process();
    }
}
