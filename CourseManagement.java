class CourseManagement {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "Global Institute";

    // Constructor
    public CourseManagement(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Institute: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: $" + fee);
    }

    // Class method to update institute name
    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        CourseManagement course1 = new CourseManagement("Java Programming", 6, 500.0);
        CourseManagement course2 = new CourseManagement("Web Development", 4, 400.0);

        course1.displayCourseDetails();
        course2.displayCourseDetails();

        CourseManagement.updateInstituteName("Tech Academy");
        System.out.println("\nAfter updating institute name:\n");

        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}