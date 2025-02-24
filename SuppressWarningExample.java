import java.util.ArrayList;

public class SuppressWarningExample {

    @SuppressWarnings("unchecked") // Suppressing unchecked warning
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // No generics used
        list.add("Hello");
        list.add("World");

        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
