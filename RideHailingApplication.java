// Abstract class representing a Vehicle
abstract class Vehicle {
    protected String vehicleId;
    protected String driverName;
    protected double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Abstract method to calculate fare
    public abstract double calculateFare(double distance);

    // Concrete method to get vehicle details
    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: $" + ratePerKm;
    }
}

// Interface for GPS functionality
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Car class extending Vehicle and implementing GPS
class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.location = location;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Bike class extending Vehicle and implementing GPS
class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.location = location;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Auto class extending Vehicle and implementing GPS
class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.location = location;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Main class to demonstrate polymorphism
public class RideHailingApplication {
    public static void main(String[] args) {
        Vehicle[] rides = {
            new Car("C001", "Alice", 2.5, "Downtown"),
            new Bike("B001", "Bob", 1.2, "Uptown"),
            new Auto("A001", "Charlie", 1.8, "Suburb")
        };

        double distance = 10.0; // Distance in km
        for (Vehicle ride : rides) {
            System.out.println(ride.getVehicleDetails());
            System.out.println("Fare for " + distance + " km: $" + ride.calculateFare(distance));
            if (ride instanceof GPS) {
                System.out.println("Current Location: " + ((GPS) ride).getCurrentLocation());
            }
            System.out.println("-----------------------------------");
        }
    }
}
