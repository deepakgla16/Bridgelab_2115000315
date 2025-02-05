class Vehicle {
    // Static variable shared across all vehicles
    private static double registrationFee = 500.00; // Default registration fee

    // Instance variables
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber; // Final to ensure immutability

    // Constructor using 'this' to resolve ambiguity
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method to update the registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Updated Registration Fee: $" + registrationFee);
    }

    // Method to display vehicle registration details (checking instanceof)
    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + this.ownerName);
            System.out.println("Vehicle Type: " + this.vehicleType);
            System.out.println("Registration Number: " + this.registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("Invalid vehicle object.");
        }
    }

    public static void main(String[] args) {
        // Creating Vehicle objects
        Vehicle vehicle1 = new Vehicle("Alice Johnson", "Car", "CAR12345");
        Vehicle vehicle2 = new Vehicle("Bob Smith", "Motorcycle", "BIKE6789");

        // Displaying vehicle details before fee update
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();

        // Updating the registration fee
        Vehicle.updateRegistrationFee(600.00);

        // Displaying vehicle details after fee update
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}
