package Assignment2;
import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3]; // 2D array to store weight, height, and BMI

        // Input weight and height for each member
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for member " + (i + 1) + ": ");
            data[i][0] = scanner.nextDouble();

            System.out.print("Enter height (cm) for member " + (i + 1) + ": ");
            data[i][1] = scanner.nextDouble();
        }

        // Calculate BMI for each member
        calculateBMI(data);

        // Determine BMI status for each member
        String[] status = determineBMIStatus(data);

        // Display results
        System.out.println("\nHeight (cm)\tWeight (kg)\tBMI\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t%s\n", data[i][1], data[i][0], data[i][2], status[i]);
        }
    }

    // Calculates BMI and stores it in the third column of the 2D array
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < 10; i++) {
            double heightMeters = data[i][1] / 100; // Convert cm to meters
            data[i][2] = data[i][0] / (heightMeters * heightMeters);
        }
    }

    // Determines BMI status and returns an array of status strings
    public static String[] determineBMIStatus(double[][] data) {
        String[] status = new String[10];
        for (int i = 0; i < 10; i++) {
            if (data[i][2] < 18.5) {
                status[i] = "Underweight";
            } else if (data[i][2] < 25.0) {
                status[i] = "Normal";
            } else if (data[i][2] < 30.0) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }
}