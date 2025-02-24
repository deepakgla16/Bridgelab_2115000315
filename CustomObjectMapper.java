import java.lang.reflect.Field;
import java.util.Map;

class User {
    private String name;
    private int age;

    // Default constructor
    public User() {}

    // Method to display user details
    public void display() {
        System.out.println("User Name: " + name);
        System.out.println("User Age: " + age);
    }
}

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance of the given class
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Set field values using reflection
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true); // Allow modification of private fields
                    field.set(obj, fieldValue);
                } catch (NoSuchFieldException e) {
                    System.out.println("Warning: No field found for key: " + fieldName);
                }
            }
            return obj;

        } catch (Exception e) {
            throw new RuntimeException("Failed to create object", e);
        }
    }

    public static void main(String[] args) {
        // Sample properties map
        Map<String, Object> userProperties = Map.of(
            "name", "Alice",
            "age", 25
        );

        // Convert the map to a User object
        User user = toObject(User.class, userProperties);

        // Display the populated User object
        user.display();
    }
}
