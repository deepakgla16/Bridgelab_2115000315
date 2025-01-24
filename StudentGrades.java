package Assignment2;
import java.util.Scanner;

public class StudentGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Create arrays to store marks, percentages, and grades
        int[] physicsMarks = new int[numStudents];
        int[] chemistryMarks = new int[numStudents];
        int[] mathsMarks = new int[numStudents];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        // Get marks for each student
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");

            // Input validation for physics marks
            do {
                System.out.print("Physics: ");
                physicsMarks[i] = scanner.nextInt();
            } while (physicsMarks[i] < 0);

            // Input validation for chemistry marks
            do {
                System.out.print("Chemistry: ");
                chemistryMarks[i] = scanner.nextInt();
            } while (chemistryMarks[i] < 0);

            // Input validation for maths marks
            do {
                System.out.print("Maths: ");
                mathsMarks[i] = scanner.nextInt();
            } while (mathsMarks[i] < 0);

            // Calculate percentage
            percentages[i] = (physicsMarks[i] + chemistryMarks[i] + mathsMarks[i]) / 3.0;

            // Determine grade
            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        // Display results
        System.out.println("\nStudent\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%d\t%d\t\t%d\t\t%d\t\t%.2f\t\t%c\n", i + 1, physicsMarks[i], chemistryMarks[i], mathsMarks[i], percentages[i], grades[i]);
        }

        scanner.close();
    }
}