package Assignment2;
import java.util.Scanner;

public class WindChillCalculator {

    // Method to calculate the wind chill temperature
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for temperature and wind speed
        System.out.print("Enter the temperature in Fahrenheit: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the wind speed in miles per hour: ");
        double windSpeed = scanner.nextDouble();

        // Validate inputs: wind speed must be >= 2 and temperature must be <= 50
        if (temperature > 50 || windSpeed < 2) {
            System.out.println("Wind chill temperature calculation is not valid for these conditions:");
            System.out.println("- Temperature must be 50°F or lower.");
            System.out.println("- Wind speed must be 2 mph or greater.");
        } else {
            // Calculate and display the wind chill
            double windChill = calculateWindChill(temperature, windSpeed);
            System.out.printf("The wind chill temperature is: %.2f°F%n", windChill);
        }

        scanner.close();
    }
}
