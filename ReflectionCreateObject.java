import java.lang.reflect.Constructor;

class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class ReflectionCreateObject {
    public static void main(String[] args) {
        try {
            // Get the Class object for Student
            Class<?> clazz = Class.forName("Student");

            // Get the no-argument constructor
            Constructor<?> constructor = clazz.getDeclaredConstructor();

            // Create an instance using newInstance()
            Object studentInstance = constructor.newInstance();

            // Invoke the display method
            Method displayMethod = clazz.getMethod("display");
            displayMethod.invoke(studentInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
