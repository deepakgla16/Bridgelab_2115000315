// Abstract class representing a Product
abstract class Product {
    protected int productId;
    protected String name;
    protected double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Abstract method to calculate discount
    public abstract double calculateDiscount();

    // Getters
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    // Setters
    public void setPrice(double price) { this.price = price; }
}

// Interface for taxable products
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics class extending Product and implementing Taxable
class Electronics extends Product implements Taxable {
    private static final double TAX_RATE = 0.15; // 15% tax
    private static final double DISCOUNT = 0.10; // 10% discount

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * DISCOUNT;
    }

    @Override
    public double calculateTax() {
        return price * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: 15%";
    }
}

// Clothing class extending Product and implementing Taxable
class Clothing extends Product implements Taxable {
    private static final double TAX_RATE = 0.08; // 8% tax
    private static final double DISCOUNT = 0.05; // 5% discount

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * DISCOUNT;
    }

    @Override
    public double calculateTax() {
        return price * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: 8%";
    }
}

// Groceries class extending Product (not taxable)
class Groceries extends Product {
    private static final double DISCOUNT = 0.02; // 2% discount

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * DISCOUNT;
    }
}

// Main class to demonstrate polymorphism
 class ECommercePlatform {
    public static void main(String[] args) {
        Product[] products = {
            new Electronics(101, "Laptop", 1000),
            new Clothing(202, "T-Shirt", 50),
            new Groceries(303, "Apple", 2)
        };

        for (Product product : products) {
            double discount = product.calculateDiscount();
            double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;
            double finalPrice = product.getPrice() + tax - discount;
            
            System.out.println("Product: " + product.getName());
            System.out.println("Base Price: $" + product.getPrice());
            System.out.println("Discount: $" + discount);
            System.out.println("Tax: $" + tax);
            System.out.println("Final Price: $" + finalPrice);
            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }
            System.out.println("-----------------------------------");
        }
    }
}
