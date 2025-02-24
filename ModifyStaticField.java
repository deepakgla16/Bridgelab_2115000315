import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            // Get the Class object
            Class<?> clazz = Configuration.class;

            // Access the private static field "API_KEY"
            Field apiKeyField = clazz.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true); // Allow modification of private field

            // Modify the static field
            apiKeyField.set(null, "NEW_SECURE_KEY");

            // Retrieve and print the modified value
            System.out.println("Updated API_KEY: " + Configuration.getApiKey());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
