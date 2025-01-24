package Assignment2;
import java.util.Scanner;

public class BMIProgram {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take input for the number of persons
        System.out.print("Enter the number of persons: ");
        int number = scanner.nextInt();

        // Create a 2D array to store height, weight, and BMI for each person
        double[][] personData = new double[number][3];  // 0: height, 1: weight, 2: BMI
        String[] weightStatus = new String[number];     // To store the weight status for each person

        // Take input for weight and height for each person and calculate BMI
        for (int i = 0; i < number; i++) {
            // Get valid height and weight inputs
            double height, weight;

            // Input height
            do {
                System.out.print("Enter height (in meters) for person " + (i + 1) + ": ");
                height = scanner.nextDouble();
                if (height <= 0) {
                    System.out.println("Height must be a positive value. Please enter again.");
                }
            } while (height <= 0);

            // Input weight
            do {
                System.out.print("Enter weight (in kg) for person " + (i + 1) + ": ");
                weight = scanner.nextDouble();
                if (weight <= 0) {
                    System.out.println("Weight must be a positive value. Please enter again.");
                }
            } while (weight <= 0);

            // Calculate BMI: BMI = weight / (height * height)
            double bmi = weight / (height * height);

            // Store the data in the personData array
            personData[i][0] = height;
            personData[i][1] = weight;
            personData[i][2] = bmi;

            // Determine the weight status based on BMI
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi >= 25 && bmi <= 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display the results for each person
        System.out.println("\nPerson Details (Height, Weight, BMI, Status):");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.println("  Height: " + personData[i][0] + " meters");
            System.out.println("  Weight: " + personData[i][1] + " kg");
            System.out.println("  BMI: " + String.format("%.2f", personData[i][2]));
            System.out.println("  Weight Status: " + weightStatus[i]);
            System.out.println();
        }

        // Close the scanner
        scanner.close();
    }
}
