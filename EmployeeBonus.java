package Assignment2;
import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take salary and years of service as input
        System.out.print("Enter the salary of the employee: ");
        double salary = scanner.nextDouble();
        
        System.out.print("Enter the years of service of the employee: ");
        int yearsOfService = scanner.nextInt();

        // Check if the employee is eligible for the bonus
        if (yearsOfService > 5) {
            // Calculate 5% bonus
            double bonus = salary * 0.05;
            System.out.println("The bonus amount is: " + bonus);
        } else {
            System.out.println("The employee is not eligible for a bonus.");
        }

        scanner.close();
    }
}
