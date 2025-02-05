class Student {
    // Static variable shared across all students
    private static String universityName = "Global University";
    private static int totalStudents = 0;

    // Instance variables
    private String name;
    private final int rollNumber; // Final to ensure immutability
    private char grade;

    // Constructor using 'this' to resolve ambiguity
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++; // Increment total students on new student creation
    }

    // Static method to display the total number of students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Method to display student details (checking instanceof)
    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Student Name: " + this.name);
            System.out.println("Roll Number: " + this.rollNumber);
            System.out.println("Grade: " + this.grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }

    // Method to update student grade
    public void updateGrade(char newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated for Roll Number " + this.rollNumber + " to: " + this.grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }

    public static void main(String[] args) {
        // Display the university name
        System.out.println("Welcome to " + universityName);

        // Creating Student objects
        Student student1 = new Student("Alice Johnson", 101, 'A');
        Student student2 = new Student("Bob Smith", 102, 'B');

        // Displaying student details
        student1.displayStudentDetails();
        student2.displayStudentDetails();

        // Updating grade for a student
        student2.updateGrade('A');

        // Displaying total students
        Student.displayTotalStudents();
    }
}
