class Circle {
    private double radius;

    // Default constructor
    public Circle() {
        this(1.0); // Default radius value
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Getter method
    public double getRadius() {
        return radius;
    }
}
public class CircleMain {

    public static void main(String[] args) {
        Circle defaultCircle = new Circle();
        Circle customCircle = new Circle(5.5);

        System.out.println("Default Circle Radius: " + defaultCircle.getRadius());
        System.out.println("Custom Circle Radius: " + customCircle.getRadius());
    }
}