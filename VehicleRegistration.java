class VehicleRegistration {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 100.0; // Default registration fee

    // Constructor
    public VehicleRegistration(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    // Class method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        VehicleRegistration vehicle1 = new VehicleRegistration("Alice", "Car");
        VehicleRegistration vehicle2 = new VehicleRegistration("Bob", "Motorcycle");

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();

        VehicleRegistration.updateRegistrationFee(150.0);
        System.out.println("\nAfter updating registration fee:\n");

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}