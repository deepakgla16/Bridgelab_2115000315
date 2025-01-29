import java.time.LocalDate;

public class DateArithmeticOperation {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2023, 1, 1);
        
        LocalDate newDate = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
        
        System.out.println("Original date: " + date);
        System.out.println("New date after adding and subtracting: " + newDate);
    }
}
