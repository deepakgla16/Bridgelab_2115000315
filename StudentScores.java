package Assignment2;
import java.util.Random;
import java.util.Scanner;

public class StudentScores {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Generate random scores for each student
        int[][] scores = generateRandomScores(numStudents);

        // Calculate total, average, and percentage for each student
        double[][] results = calculateResults(scores);

        // Display the scorecard
        displayScorecard(scores, results);
    }

    // Generates random 2-digit scores for Physics, Chemistry, and Maths for each student
    public static int[][] generateRandomScores(int numStudents) {
        Random random = new Random();
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = random.nextInt(100); // Generate random score between 0 and 99
            }
        }
        return scores;
    }

    // Calculates total, average, and percentage for each student
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3;
            double percentage = (total / 300) * 100;
            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = Math.round(percentage * 100.0) / 100.0; // Round percentage to 2 decimal places
        }
        return results;
    }

    // Displays the scorecard with scores, total, average, and percentage
    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade\tRemarks");
        System.out.println("---------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.2f\t%.2f\t\t%.2f\t\t%s\t\t%s\n",
                    i + 1, scores[i][0], scores[i][1], scores[i][2], results[i][0], results[i][1], results[i][2],
                    getGrade(results[i][2]), getRemarks(results[i][2]));
        }

        System.out.println("---------------------------------------------------------------------------------");
    }

    // Determines the grade based on percentage
    public static String getGrade(double percentage) {
        if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "R";
        }
    }

    // Determines the remarks based on grade
    public static String getRemarks(double percentage) {
        String grade = getGrade(percentage);
        switch (grade) {
            case "A":
                return "(Level 4, above agency-normalized standards)";
            case "B":
                return "(Level 3, at agency-normalized standards)";
            case "C":
                return "(Level 2, below, but approaching agency-normalized standards)";
            case "D":
                return "(Level 1, well below agency-normalized standards)";
            case "E":
                return "(Level 1-, too below agency-normalized standards)";
            case "R":
                return "(Remedial standards)";
            default:
                return "";
        }
    }
}