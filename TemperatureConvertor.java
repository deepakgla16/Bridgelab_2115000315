import java.util.Scanner;

public class TemperatureConvertor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double temperature, convertedTemperature;
        String unit;

        System.out.print("Enter the temperature: ");
        temperature = input.nextDouble();
        input.nextLine();
        System.out.print("Enter the unit (C/F): ");
        unit = input.nextLine();

        if (unit.equalsIgnoreCase("C")) {
            convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.println(temperature + "°C is equal to " + convertedTemperature + "°F.");
        } 
        else if (unit.equalsIgnoreCase("F")) {
            convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.println(temperature + "°F is equal to " + convertedTemperature + "°C.");
        } 
        else {
            System.out.println("Invalid unit.");
        }

        input.close();
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
