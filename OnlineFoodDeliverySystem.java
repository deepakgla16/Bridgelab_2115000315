// Abstract class representing a Food Item
abstract class FoodItem {
    protected String itemName;
    protected double price;
    protected int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method to calculate total price
    public abstract double calculateTotalPrice();

    // Concrete method to get item details
    public String getItemDetails() {
        return "Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity;
    }

    // Getters
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}

// Interface for discountable items
interface Discountable {
    void applyDiscount(double discountRate);
    String getDiscountDetails();
}

// VegItem class extending FoodItem and implementing Discountable
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public void applyDiscount(double discountRate) {
        price -= price * discountRate / 100;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount Applied";
    }
}

// NonVegItem class extending FoodItem and implementing Discountable
class NonVegItem extends FoodItem implements Discountable {
    private static final double ADDITIONAL_CHARGE = 5.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (price * quantity) + ADDITIONAL_CHARGE;
    }

    @Override
    public void applyDiscount(double discountRate) {
        price -= price * discountRate / 100;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount Applied";
    }
}

// Main class to demonstrate polymorphism
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem[] order = {
            new VegItem("Paneer Butter Masala", 12.99, 2),
            new NonVegItem("Chicken Biryani", 15.99, 1)
        };

        for (FoodItem item : order) {
            System.out.println(item.getItemDetails());
            System.out.println("Total Price: $" + item.calculateTotalPrice());
            
            if (item instanceof Discountable) {
                ((Discountable) item).applyDiscount(10);
                System.out.println(((Discountable) item).getDiscountDetails());
                System.out.println("Discounted Price: $" + item.calculateTotalPrice());
            }
            System.out.println("-----------------------------------");
        }
    }
}
