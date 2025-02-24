import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value(); // Specifies the allowed role
}

// Step 2: Create a User class to simulate roles
class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Step 3: Apply the @RoleAllowed annotation to a method
class SecureOperations {

    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task executed successfully!");
    }

    public void publicTask() {
        System.out.println("Public task executed!");
    }
}

// Step 4: Validate access before invoking the method
public class UserSecureOperations {
    public static void main(String[] args) {
        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");

        SecureOperations operations = new SecureOperations();

        executeMethodIfAllowed(operations, "performAdminTask", adminUser);  // Should execute
        executeMethodIfAllowed(operations, "performAdminTask", normalUser); // Should deny access
        executeMethodIfAllowed(operations, "publicTask", normalUser);        // Should execute
    }

    private static void executeMethodIfAllowed(Object obj, String methodName, User user) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (!roleAllowed.value().equals(user.getRole())) {
                    System.out.println("Access Denied! " + user.getRole() + " is not allowed to execute " + methodName);
                    return;
                }
            }

            method.invoke(obj); // Execute the method if allowed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
