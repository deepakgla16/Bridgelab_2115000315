package Assignment2;
import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Define constants
        int numberOfEmployees = 10;
        double[] salary = new double[numberOfEmployees];
        double[] yearsOfService = new double[numberOfEmployees];
        double[] bonus = new double[numberOfEmployees];
        double[] newSalary = new double[numberOfEmployees];

        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        // Loop to take input for salary and years of service
        for (int i = 0; i < numberOfEmployees; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter salary for employee " + (i + 1) + ": ");
                salary[i] = scanner.nextDouble();

                System.out.print("Enter years of service for employee " + (i + 1) + ": ");
                yearsOfService[i] = scanner.nextDouble();

                // Input validation
                if (salary[i] > 0 && yearsOfService[i] >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter positive salary and valid years of service.");
                }
            }
        }

        // Loop to calculate bonus, new salary, and total values
        for (int i = 0; i < numberOfEmployees; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05; // 5% bonus for employees with more than 5 years of service
            } else {
                bonus[i] = salary[i] * 0.02; // 2% bonus for employees with less than or equal to 5 years of service
            }

            newSalary[i] = salary[i] + bonus[i]; // New salary is the old salary + bonus

            // Update total bonus and salary values
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // Display the results
        System.out.println("\nEmployee Bonus Summary:");
        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("Employee " + (i + 1) + ":");
            System.out.println("  Old Salary: " + salary[i]);
            System.out.println("  Years of Service: " + yearsOfService[i]);
            System.out.println("  Bonus: " + bonus[i]);
            System.out.println("  New Salary: " + newSalary[i]);
            System.out.println();
        }

        // Display the total bonus, total old salary, and total new salary
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);

        // Close the scanner
        scanner.close();
    }
}
