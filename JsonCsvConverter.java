import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.*;
import java.util.*;

public class JsonCsvConverter {

    public static void main(String[] args) {
        String jsonFile = "students.json";  // JSON input file
        String csvFile = "students.csv";    // CSV output file
        String newJsonFile = "converted_students.json"; // JSON after conversion back

        // Convert JSON to CSV
        jsonToCsv(jsonFile, csvFile);

        // Convert CSV back to JSON
        csvToJson(csvFile, newJsonFile);
    }

    // Convert JSON to CSV
    public static void jsonToCsv(String jsonFile, String csvFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON file into List of Student objects
            List<Student> students = objectMapper.readValue(new File(jsonFile), new TypeReference<List<Student>>() {});

            // Write to CSV
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
                bw.write("ID,Name,Age,Marks\n"); // CSV Header

                for (Student student : students) {
                    bw.write(student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getMarks() + "\n");
                }
            }

            System.out.println("JSON successfully converted to CSV: " + csvFile);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Convert CSV to JSON
    public static void csvToJson(String csvFile, String jsonFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 4) {
                    students.add(new Student(
                        Integer.parseInt(data[0].trim()), // ID
                        data[1].trim(), // Name
                        Integer.parseInt(data[2].trim()), // Age
                        Double.parseDouble(data[3].trim()) // Marks
                    ));
                }
            }

            // Write back to JSON
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFile), students);

            System.out.println("CSV successfully converted to JSON: " + jsonFile);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

// Student class
class Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    public Student() {} // Default constructor

    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getMarks() { return marks; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setMarks(double marks) { this.marks = marks; }
}
