import java.io.*;

public class StudentDataStream {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        // Writing student data
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            dos.writeInt(101); // Roll number
            dos.writeUTF("Alice"); // Name
            dos.writeDouble(3.8); // GPA

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.5);

            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing student data: " + e.getMessage());
        }

        // Reading student data
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("\nRetrieved Student Data:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading student data: " + e.getMessage());
        }
    }
}
