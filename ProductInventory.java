class ProductInventory {
    private String productName;
    private double price;
    private static int totalProducts = 0;

    // Constructor
    public ProductInventory(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    // Instance method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }

    // Class method to display total products
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public static void main(String[] args) {
        ProductInventory product1 = new ProductInventory("Laptop", 1200.50);
        ProductInventory product2 = new ProductInventory("Smartphone", 699.99);

        product1.displayProductDetails();
        product2.displayProductDetails();

        ProductInventory.displayTotalProducts();
    }
}
