import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int studentId;
    private List<Course> courses;

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
        System.out.println(name + " has enrolled in " + course.getCourseName());
    }

    public void showEnrolledCourses() {
        System.out.println(name + "'s Enrolled Courses:");
        for (Course course : courses) {
            System.out.println("  - " + course.getCourseName());
        }
    }
}


class Professor {
    private String name;
    private int professorId;

    public Professor(String name, int professorId) {
        this.name = name;
        this.professorId = professorId;
    }

    public String getName() {
        return name;
    }
}


class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println(professor.getName() + " is assigned to teach " + courseName);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not Assigned"));
        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println("  - " + student.getName());
        }
    }
}


public class UniversityManagementSystem {
    public static void main(String[] args) {
        
        Student s1 = new Student("Alice", 101);
        Student s2 = new Student("Bob", 102);

        
        Professor p1 = new Professor("Dr. Smith", 201);
        Professor p2 = new Professor("Dr. Johnson", 202);

        
        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Machine Learning");

        
        c1.assignProfessor(p1);
        c2.assignProfessor(p2);

        
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);

        
        System.out.println();
        c1.showCourseDetails();
        System.out.println();
        c2.showCourseDetails();
        System.out.println();

        
        s1.showEnrolledCourses();
        s2.showEnrolledCourses();
    }
}
