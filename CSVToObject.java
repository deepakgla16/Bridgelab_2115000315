import java.io.*;
import java.util.*;
class Student {
    private String id;
    private String name;
    private int age;
    private double marks;

    public Student(String id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("Student[ID=%s, Name=%s, Age=%d, Marks=%.2f]", id, name, age, marks);
    }
}



public class CSVToObject {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Update with your CSV file path
        List<Student> students = readStudentsFromCSV(filePath);
        
        // Print all student objects
        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> readStudentsFromCSV(String filePath) {
        List<Student> studentList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip the header row
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 4) { // Ensure proper format
                    String id = data[0].trim();
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    double marks = Double.parseDouble(data[3].trim());

                    Student student = new Student(id, name, age, marks);
                    studentList.add(student);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return studentList;
    }
}
