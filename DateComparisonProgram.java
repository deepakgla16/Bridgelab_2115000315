import java.time.LocalDate;
import java.util.Scanner;

public class DateComparisonProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first date (yyyy-MM-dd): ");
        String date1 = input.nextLine();
        
        System.out.print("Enter second date (yyyy-MM-dd): ");
        String date2 = input.nextLine();
        
        LocalDate firstDate = LocalDate.parse(date1);
        LocalDate secondDate = LocalDate.parse(date2);
        
        if (firstDate.isBefore(secondDate)) {
            System.out.println("First date is before the second date.");
        } 
        else if (firstDate.isAfter(secondDate)) {
            System.out.println("First date is after the second date.");
        } 
        else {
            System.out.println("Both dates are the same.");
        }
    }
}
