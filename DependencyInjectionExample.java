import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @Inject annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

// Step 2: Define a simple Service Interface and Implementation
interface Service {
    void perform();
}

class ServiceImpl implements Service {
    public void perform() {
        System.out.println("Service is performing...");
    }
}

// Step 3: Define a Client class that depends on Service
class Client {
    @Inject
    private Service service;

    public void execute() {
        service.perform();
    }
}

// Step 4: Implement a Simple Dependency Injection Container
class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public void register(Class<?> clazz) throws Exception {
        // Create an instance of the class
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object instance = constructor.newInstance();

        // Store the instance in the map
        instances.put(clazz, instance);
    }

    public <T> T getInstance(Class<T> clazz) throws Exception {
        // Get the instance from the map
        T instance = (T) instances.get(clazz);
        if (instance == null) {
            throw new RuntimeException("No registered instance found for " + clazz.getName());
        }

        // Inject dependencies
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> dependencyType = field.getType();
                Object dependency = instances.get(dependencyType);
                if (dependency == null) {
                    throw new RuntimeException("No registered instance found for dependency " + dependencyType.getName());
                }

                // Inject the dependency
                field.setAccessible(true);
                field.set(instance, dependency);
            }
        }
        return instance;
    }
}

// Step 5: Demonstrate Dependency Injection
public class DependencyInjectionExample {
    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();

        // Register classes
        container.register(ServiceImpl.class);
        container.register(Client.class);

        // Retrieve an instance of Client with dependencies injected
        Client client = container.getInstance(Client.class);
        client.execute();
    }
}
