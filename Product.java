class Product {
    // Static variable shared across all products
    private static double discount = 10.0; // Default discount percentage

    // Instance variables
    private String productName;
    private double price;
    private int quantity;
    private final int productID; // Final to ensure immutability

    // Constructor using 'this' to resolve ambiguity
    public Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    // Static method to update the discount percentage
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Updated discount: " + discount + "%");
    }

    // Method to calculate and display product details (checking instanceof)
    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + this.productID);
            System.out.println("Product Name: " + this.productName);
            System.out.println("Price: $" + this.price);
            System.out.println("Quantity: " + this.quantity);
            System.out.println("Discount Applied: " + discount + "%");
            System.out.println("Final Price after Discount: $" + getDiscountedPrice());
        } else {
            System.out.println("Invalid product object.");
        }
    }

    // Method to calculate discounted price
    public double getDiscountedPrice() {
        return price - (price * discount / 100);
    }

    public static void main(String[] args) {
        // Creating Product objects
        Product product1 = new Product("Laptop", 1200.00, 2, 101);
        Product product2 = new Product("Smartphone", 800.00, 1, 102);

        // Displaying product details before discount update
        product1.displayProductDetails();
        product2.displayProductDetails();

        // Updating discount
        Product.updateDiscount(15.0);

        // Displaying product details after discount update
        product1.displayProductDetails();
        product2.displayProductDetails();
    }
}
