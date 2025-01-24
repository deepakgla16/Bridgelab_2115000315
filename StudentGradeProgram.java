package Assignment2;
import java.util.Scanner;

public class StudentGradeProgram {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take input for the number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        // Create a 2D array to store marks for Physics, Chemistry, and Maths
        // Each row represents a student, and each column represents marks in Physics, Chemistry, and Maths
        double[][] marks = new double[numberOfStudents][3];

        // Array to store the percentage of each student
        double[] percentages = new double[numberOfStudents];

        // Array to store the grade of each student
        String[] grades = new String[numberOfStudents];

        // Input marks for each student
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nEnter marks for student " + (i + 1));

            // Input marks for Physics
            do {
                System.out.print("Enter marks in Physics (0-100): ");
                marks[i][0] = scanner.nextDouble();
                if (marks[i][0] < 0 || marks[i][0] > 100) {
                    System.out.println("Marks should be between 0 and 100. Please enter again.");
                }
            } while (marks[i][0] < 0 || marks[i][0] > 100);

            // Input marks for Chemistry
            do {
                System.out.print("Enter marks in Chemistry (0-100): ");
                marks[i][1] = scanner.nextDouble();
                if (marks[i][1] < 0 || marks[i][1] > 100) {
                    System.out.println("Marks should be between 0 and 100. Please enter again.");
                }
            } while (marks[i][1] < 0 || marks[i][1] > 100);

            // Input marks for Maths
            do {
                System.out.print("Enter marks in Maths (0-100): ");
                marks[i][2] = scanner.nextDouble();
                if (marks[i][2] < 0 || marks[i][2] > 100) {
                    System.out.println("Marks should be between 0 and 100. Please enter again.");
                }
            } while (marks[i][2] < 0 || marks[i][2] > 100);

            // Calculate percentage for the student
            double totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalMarks / 300) * 100;

            // Assign grade based on the percentage
            if (percentages[i] >= 90) {
                grades[i] = "A";
            } else if (percentages[i] >= 75) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 45) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }

        // Display the results for each student
        System.out.println("\nResults for all students:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.println("  Physics: " + marks[i][0] + " marks");
            System.out.println("  Chemistry: " + marks[i][1] + " marks");
            System.out.println("  Maths: " + marks[i][2] + " marks");
            System.out.println("  Percentage: " + String.format("%.2f", percentages[i]) + "%");
            System.out.println("  Grade: " + grades[i]);
        }

        // Close the scanner
        scanner.close();
    }
}
