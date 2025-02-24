import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Define an interface
interface Greeting {
    void sayHello(String name);
}

// Implement the interface
class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// Dynamic Proxy Handler for Logging
class LoggingInvocationHandler implements InvocationHandler {
    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Logging: Calling method -> " + method.getName());
        return method.invoke(target, args);
    }
}

// Proxy Factory to create dynamic proxies
class ProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
            interfaceType.getClassLoader(),
            new Class<?>[]{interfaceType},
            new LoggingInvocationHandler(target)
        );
    }
}

public class DynamicProxyExample {
    public static void main(String[] args) {
        // Create an original Greeting object
        Greeting greeting = new GreetingImpl();

        // Create a dynamic proxy with logging
        Greeting proxyGreeting = ProxyFactory.createProxy(greeting, Greeting.class);

        // Call method on proxy object
        proxyGreeting.sayHello("Alice");
    }
}
