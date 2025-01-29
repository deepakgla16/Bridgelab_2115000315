import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormattingProgram {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        
        System.out.println("Formatted date (dd/MM/yyyy): " + currentDate.format(formatter1));
        System.out.println("Formatted date (yyyy-MM-dd): " + currentDate.format(formatter2));
        System.out.println("Formatted date (EEE, MMM dd, yyyy): " + currentDate.format(formatter3));
    }
}
