// Circle class to calculate and display area and circumference
class AreaOfCircle {
    private double radius;

    // Constructor to initialize radius
    public AreaOfCircle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area of the circle
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference of the circle
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display circle details
    public void displayDetails() {
        System.out.println("Circle Details:");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }
}
    // Main method to test the Circle class
    public class Main1{
    public static void main(String[] args) {
        // Creating a Circle object
        AreaOfCircle circle1 = new AreaOfCircle(5.5);

        // Displaying circle details
        circle1.displayDetails();
    }
}
