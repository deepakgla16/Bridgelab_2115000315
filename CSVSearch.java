import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CSVSearch {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Update with your file path
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();
        searchEmployee(filePath, searchName);
        scanner.close();
    }

    public static void searchEmployee(String filePath, String searchName) {
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip the header row
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 4) {
                    String name = data[1].trim();
                    if (name.equalsIgnoreCase(searchName)) {
                        System.out.printf("Employee Found: %s%nDepartment: %s%nSalary: %s%n",
                                name, data[2].trim(), data[3].trim());
                        found = true;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }
}
