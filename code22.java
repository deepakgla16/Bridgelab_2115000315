package Assignment2;

import java.util.Scanner;

public class code22 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the salary
        System.out.print("Enter the salary: ");
        double salary = input.nextDouble();

        // Prompt user to enter the bonus
        System.out.print("Enter the bonus: ");
        double bonus = input.nextDouble();

        // Compute total income by adding salary and bonus
        double totalIncome = salary + bonus;

        // Output the result
        System.out.printf("The salary is INR %.2f and bonus is INR %.2f. Hence, Total Income is INR %.2f\n", 
                          salary, bonus, totalIncome);

        // Close the scanner
        input.close();
    }
}
