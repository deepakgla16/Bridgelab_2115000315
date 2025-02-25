import java.io.*;
import java.util.regex.*;

public class CSVValidator {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Update with your file path
        validateCSV(filePath);
    }

    public static void validateCSV(String filePath) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"; // Email validation pattern
        String phoneRegex = "^[0-9]{10}$"; // Phone number must have exactly 10 digits

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 5) { // Ensure we have all required columns
                    System.out.println("Invalid row (missing columns): " + line);
                    continue;
                }

                String email = data[3].trim();
                String phone = data[4].trim();

                boolean isEmailValid = emailPattern.matcher(email).matches();
                boolean isPhoneValid = phonePattern.matcher(phone).matches();

                if (!isEmailValid) {
                    System.out.println("Invalid email in row: " + line);
                }
                if (!isPhoneValid) {
                    System.out.println("Invalid phone number in row: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
