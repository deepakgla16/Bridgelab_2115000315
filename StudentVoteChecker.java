package Assignment2;
import java.util.Scanner;

public class StudentVoteChecker {

    // Method to check if a student can vote based on their age
    public boolean canStudentVote(int age) {
        // Validate the age: if negative, return false
        if (age < 0) {
            return false;
        }
        // If age is 18 or above, return true
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();
        
        // Define an array to hold the ages of 10 students
        int[] studentAges = new int[10];
        
        // Loop to take user input for the ages of 10 students
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter the age of student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();
        }

        // Check if each student can vote and display the result
        for (int i = 0; i < 10; i++) {
            boolean canVote = checker.canStudentVote(studentAges[i]);
            if (canVote) {
                System.out.println("Student " + (i + 1) + " with age " + studentAges[i] + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " with age " + studentAges[i] + " cannot vote.");
            }
        }
        
        scanner.close();
    }
}
