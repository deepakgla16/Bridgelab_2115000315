import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class ReflectionAccessPrivateField {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            Person person = new Person(25);
            person.displayAge();

            // Get the Class object
            Class<?> clazz = person.getClass();

            // Access the private field "age"
            Field ageField = clazz.getDeclaredField("age");
            ageField.setAccessible(true); // Allow modification of private fields

            // Modify the age field
            ageField.set(person, 30);

            // Retrieve the modified value
            int modifiedAge = (int) ageField.get(person);
            System.out.println("Modified Age: " + modifiedAge);

            // Display updated value using the method
            person.displayAge();
            
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
