import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

// Step 1: Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value(); // Specifies the maximum allowed length
}

// Step 2: Apply @MaxLength annotation to a field in the User class
class User {

    @MaxLength(10) // Maximum allowed length for username is 10
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
        System.out.println("User created with username: " + username);
    }

    // Step 3: Validate the field length using Reflection
    private void validateMaxLength(String username) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                if (username.length() > annotation.value()) {
                    throw new IllegalArgumentException("Username exceeds maximum length of " + annotation.value() + " characters.");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

// Step 4: Test the annotation with valid and invalid inputs
public class UserMain {
    public static void main(String[] args) {
        try {
            User user1 = new User("JohnDoe"); // Valid
            User user2 = new User("VeryLongUsername"); // Invalid, exceeds 10 characters
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
