package Assignment2;
import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        // Define an array to store the ages of 10 students
        int[] ages = new int[10];
        
        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Loop to take input for all 10 students' ages
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
            
            // Check if the age is negative
            if (ages[i] < 0) {
                System.out.println("Invalid age for student " + (i + 1) + ".");
            } else if (ages[i] >= 18) {
                System.out.println("The student with age " + ages[i] + " can vote.");
            } else {
                System.out.println("The student with age " + ages[i] + " cannot vote.");
            }
        }

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
