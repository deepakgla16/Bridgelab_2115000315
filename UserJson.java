import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name(); // Custom JSON key
}

// Step 2: Create a User class with annotated fields
class User {
    
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_email")
    private String email;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
}

// Step 3: Write a method to serialize an object to a JSON string
class JsonSerializer {

    public static String serializeToJson(Object obj) {
        Map<String, String> jsonMap = new HashMap<>();

        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                try {
                    jsonMap.put(annotation.name(), field.get(obj).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return jsonMap.toString().replace("=", ": ").replace("{", "{ ").replace("}", " }");
    }
}

// Step 4: Test the serialization
public class UserJson {
    public static void main(String[] args) {
        User user = new User("john_doe", "john@example.com", 25);
        String json = JsonSerializer.serializeToJson(user);
        System.out.println(json);
    }
}
