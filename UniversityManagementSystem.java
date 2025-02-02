// Student.java
class Student {
    // Attributes with appropriate access modifiers
    public int rollNumber;
    protected String name;
    private double CGPA;

    // Constructor to initialize the student details
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Overloaded constructor to support different initialization scenarios
    public Student(int rollNumber, String name) {
        this(rollNumber, name, 0.0);  // Default CGPA set to 0.0
    }

    // Public method to access CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to modify CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0 && CGPA <= 10) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA value. Must be between 0 and 10.");
        }
    }

    // Private method to keep logic simple and encapsulate logic
    private void calculateScholarship() {
        if (CGPA > 8) {
            System.out.println("Eligible for Scholarship.");
        } else {
            System.out.println("Not eligible for Scholarship.");
        }
    }
}

// PostgraduateStudent.java
class PostgraduateStudent extends Student {
    // Constructor to initialize the PostgraduateStudent details
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    // Demonstrating access to protected member (name) in subclass
    public void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student Name: " + name);  // Accessing protected member
        System.out.println("Postgraduate Student CGPA: " + getCGPA());
    }
}

// Main.java
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Creating an instance of Student
        Student student1 = new Student(101, "John Doe", 8.5);
        System.out.println("Student 1 CGPA: " + student1.getCGPA());

        // Modifying CGPA using the public method
        student1.setCGPA(9.2);
        System.out.println("Updated Student 1 CGPA: " + student1.getCGPA());

        // Creating an instance of PostgraduateStudent
        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Jane Smith", 9.5);
        pgStudent.displayPostgraduateDetails();
    }
}
