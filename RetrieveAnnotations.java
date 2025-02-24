import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;

// Define a custom annotation @Author
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

// Apply @Author annotation to a class
@Author(name = "John Doe")
class Book {
    public void display() {
        System.out.println("Book class method.");
    }
}

public class RetrieveAnnotations {
    public static void main(String[] args) {
        try {
            // Get the Class object
            Class<?> clazz = Book.class;

            // Retrieve the @Author annotation
            Author authorAnnotation = clazz.getAnnotation(Author.class);

            // Display annotation value if present
            if (authorAnnotation != null) {
                System.out.println("Author Name: " + authorAnnotation.name());
            } else {
                System.out.println("No @Author annotation found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
