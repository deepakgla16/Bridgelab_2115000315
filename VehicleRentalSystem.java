// Abstract class representing a Vehicle
abstract class Vehicle {
    protected String vehicleNumber;
    protected String type;
    protected double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Abstract method to calculate rental cost
    public abstract double calculateRentalCost(int days);

    // Getters
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    // Setter for rental rate
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }
}

// Interface for insurable vehicles
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Car class extending Vehicle and implementing Insurable
class Car extends Vehicle implements Insurable {
    private static final double INSURANCE_RATE = 0.05; // 5% insurance rate

    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * rentalRate;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * INSURANCE_RATE;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Rate: 5%";
    }
}

// Bike class extending Vehicle (not insurable)
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * rentalRate;
    }
}

// Truck class extending Vehicle and implementing Insurable
class Truck extends Vehicle implements Insurable {
    private static final double INSURANCE_RATE = 0.1; // 10% insurance rate

    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * rentalRate * 1.2; // Additional charge for trucks
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * INSURANCE_RATE;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Rate: 10%";
    }
}

// Main class to demonstrate polymorphism
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("CAR123", 50),
            new Bike("BIKE456", 20),
            new Truck("TRUCK789", 100)
        };

        int rentalDays = 5;
        for (Vehicle vehicle : vehicles) {
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            double insuranceCost = (vehicle instanceof Insurable) ? ((Insurable) vehicle).calculateInsurance() : 0;
            
            System.out.println("Vehicle: " + vehicle.getType() + " (" + vehicle.getVehicleNumber() + ")");
            System.out.println("Rental Cost for " + rentalDays + " days: $" + rentalCost);
            System.out.println("Insurance Cost: $" + insuranceCost);
            if (vehicle instanceof Insurable) {
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
            }
            System.out.println("-----------------------------------");
        }
    }
}
