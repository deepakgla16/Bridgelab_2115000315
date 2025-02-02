class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private static final double DAILY_RATE = 50.0; // Example rate per day

    // Default constructor
    public CarRental() {
        this("Unknown", "Standard", 1);
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate total cost
    public double calculateTotalCost() {
        return rentalDays * DAILY_RATE;
    }

    // Getter methods
    public String getCustomerName() {
        return customerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental("Alice", "Sedan", 5);
        System.out.println("Customer: " + rental1.getCustomerName() + ", Car: " + rental1.getCarModel() + ", Days: " + rental1.getRentalDays() + ", Total Cost: $" + rental1.calculateTotalCost());
    }
}
