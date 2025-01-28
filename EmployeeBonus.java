package Assignment2;
import java.util.Random;

public class EmployeeBonus {

    // Method to generate random salary and years of service for employees
    public static int[][] generateEmployeeData(int numEmployees) {
        Random random = new Random();
        int[][] employeeData = new int[numEmployees][2];  // 2D Array to store salary and years of service

        for (int i = 0; i < numEmployees; i++) {
            // Generate random salary (5-digit number)
            employeeData[i][0] = 10000 + random.nextInt(90000);  // Random salary between 10000 and 99999
            // Generate random years of service (between 1 and 20 years)
            employeeData[i][1] = 1 + random.nextInt(20);  // Random years of service between 1 and 20
        }

        return employeeData;
    }

    // Method to calculate the new salary and bonus based on years of service
    public static double[][] calculateBonusAndNewSalary(int[][] employeeData) {
        double[][] newSalaryData = new double[employeeData.length][3];  // 2D Array to store old salary, new salary, and bonus

        for (int i = 0; i < employeeData.length; i++) {
            int oldSalary = employeeData[i][0];
            int yearsOfService = employeeData[i][1];
            double bonus = 0.0;

            // Calculate bonus
            if (yearsOfService > 5) {
                bonus = oldSalary * 0.05;  // 5% bonus for more than 5 years of service
            } else {
                bonus = oldSalary * 0.02;  // 2% bonus for less than 5 years of service
            }

            // Calculate new salary
            double newSalary = oldSalary + bonus;

            // Store old salary, new salary, and bonus in the array
            newSalaryData[i][0] = oldSalary;
            newSalaryData[i][1] = newSalary;
            newSalaryData[i][2] = bonus;
        }

        return newSalaryData;
    }

    // Method to calculate the sum of old salary, new salary, and total bonus
    public static double[] calculateSums(double[][] newSalaryData) {
        double sumOldSalary = 0, sumNewSalary = 0, totalBonus = 0;

        for (int i = 0; i < newSalaryData.length; i++) {
            sumOldSalary += newSalaryData[i][0];
            sumNewSalary += newSalaryData[i][1];
            totalBonus += newSalaryData[i][2];
        }

        return new double[]{sumOldSalary, sumNewSalary, totalBonus};
    }

    // Method to display the results in a tabular format
    public static void displayResults(double[][] newSalaryData, double[] sums) {
        System.out.println("----------------------------------------------------");
        System.out.println("Employee No | Old Salary | New Salary | Bonus");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < newSalaryData.length; i++) {
            System.out.printf("%12d | %10d | %10.2f | %.2f\n", i + 1, (int) newSalaryData[i][0], newSalaryData[i][1], newSalaryData[i][2]);
        }

        System.out.println("----------------------------------------------------");
        System.out.printf("Total Old Salary: %.2f\n", sums[0]);
        System.out.printf("Total New Salary: %.2f\n", sums[1]);
        System.out.printf("Total Bonus Amount: %.2f\n", sums[2]);
        System.out.println("----------------------------------------------------");
    }

    public static void main(String[] args) {
        int numEmployees = 10;  // Number of employees
        int[][] employeeData = generateEmployeeData(numEmployees);  // Generate data for employees
        double[][] newSalaryData = calculateBonusAndNewSalary(employeeData);  // Calculate new salary and bonus
        double[] sums = calculateSums(newSalaryData);  // Calculate the sums of salaries and bonuses
        displayResults(newSalaryData, sums);  // Display results
    }
}
