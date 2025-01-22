package Assignment2;

import java.util.Scanner;

public class code24 {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter details for the journey
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter the city you are starting from: ");
        String fromCity = input.nextLine();

        System.out.print("Enter the via city: ");
        String viaCity = input.nextLine();

        System.out.print("Enter the city you are heading to: ");
        String toCity = input.nextLine();

        // Prompt user to enter distances in miles
        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = input.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = input.nextDouble();

        // Prompt user to enter the time taken for each part of the journey in hours
        System.out.print("Enter the time taken from " + fromCity + " to " + viaCity + " in hours: ");
        double timeFromToVia = input.nextDouble();

        System.out.print("Enter the time taken from " + viaCity + " to " + toCity + " in hours: ");
        double timeViaToFinalCity = input.nextDouble();

        // Calculate total distance and total time taken
        double totalDistance = fromToVia + viaToFinalCity;
        double totalTime = timeFromToVia + timeViaToFinalCity;

        // Calculate average speed (distance/time)
        double averageSpeed = totalDistance / totalTime;

        // Output the results
        System.out.printf("\nJourney Summary:\n");
        System.out.printf("Name: %s\n", name);
        System.out.printf("From: %s, Via: %s, To: %s\n", fromCity, viaCity, toCity);
        System.out.printf("Total Distance: %.2f miles\n", totalDistance);
        System.out.printf("Total Time: %.2f hours\n", totalTime);
        System.out.printf("Average Speed: %.2f miles per hour\n", averageSpeed);

        // Close the scanner
        input.close();
    }
}
