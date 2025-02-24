import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class User {
    private String name;
    private int age;
    private boolean isActive;

    public User(String name, int age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }
}

public class ObjectToJsonConverter {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Map<String, Object> jsonMap = new HashMap<>();

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true); // Allow access to private fields
                jsonMap.put(field.getName(), field.get(obj));
            }

            // Build JSON string
            StringBuilder jsonString = new StringBuilder("{");
            for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
                jsonString.append("\"").append(entry.getKey()).append("\": ");
                if (entry.getValue() instanceof String) {
                    jsonString.append("\"").append(entry.getValue()).append("\", ");
                } else {
                    jsonString.append(entry.getValue()).append(", ");
                }
            }

            // Remove trailing comma and space
            if (jsonString.length() > 1) {
                jsonString.setLength(jsonString.length() - 2);
            }
            jsonString.append("}");

            return jsonString.toString();

        } catch (Exception e) {
            throw new RuntimeException("Failed to convert object to JSON", e);
        }
    }

    public static void main(String[] args) {
        User user = new User("Alice", 25, true);
        String jsonRepresentation = toJson(user);
        System.out.println(jsonRepresentation);
    }
}
