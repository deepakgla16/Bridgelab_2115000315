package Assignment2;
public class code7 {
    public static void main(String[] args) {
        // Radius of the Earth in kilometers
        double radiusKm = 6378.0;

        // Conversion factor for kilometers to miles (1 km = 0.621371 miles)
        double kmToMiles = 0.621371;

        // Volume of the Earth in cubic kilometers
        double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);

        // Convert radius to miles and calculate volume in cubic miles
        double radiusMiles = radiusKm * kmToMiles;
        double volumeMiles3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusMiles, 3);

        // Output the results
        System.out.printf(
            "The volume of earth in cubic kilometers is %.2f and cubic miles is %.2f\n",
            volumeKm3, volumeMiles3
        );
    }
}
