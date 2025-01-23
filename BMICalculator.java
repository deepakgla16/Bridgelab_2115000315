package Assignment2;
import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter weight in kilograms: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height in centimeters: ");
        double height = scanner.nextDouble();

        // Convert height from centimeters to meters
        double heightInMeters = height / 100;

        // Calculate BMI
        double bmi = weight / (heightInMeters * heightInMeters);

        // Determine weight status
        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            status = "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        // Print the results
        System.out.println("BMI: " + bmi);
        System.out.println("Weight Status: " + status);

        scanner.close();
    }
}