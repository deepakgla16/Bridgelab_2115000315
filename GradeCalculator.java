package Assignment2;

import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter marks for Physics: ");
        int physicsMarks = scanner.nextInt();

        System.out.print("Enter marks for Chemistry: ");
        int chemistryMarks = scanner.nextInt();

        System.out.print("Enter marks for Maths: ");
        int mathsMarks = scanner.nextInt();

        // Calculate total marks and percentage
        int totalMarks = physicsMarks + chemistryMarks + mathsMarks;
        double percentage = (double) totalMarks / 300 * 100;

        // Determine grade and remarks based on percentage
        String grade;
        String remarks;

        if (percentage >= 80) {
            grade = "A";
            remarks = "Level 4, above agency-normalized standards";
        } else if (percentage >= 70) {
            grade = "B";
            remarks = "Level 3, at agency-normalized standards";
        } else if (percentage >= 60) {
            grade = "C";
            remarks = "Level 2, below, but approaching agency-normalized standards";
        } else if (percentage >= 50) {
            grade = "D";
            remarks = "Level 1, well below agency-normalized standards";
        } else if (percentage >= 40) {
            grade = "E";
            remarks = "Level 1-, too below agency-normalized standards";
        } else {
            grade = "R";
            remarks = "Remedial standards";
        }

        // Display results
        System.out.println("\nAverage Mark: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);

        scanner.close();
    }
}

