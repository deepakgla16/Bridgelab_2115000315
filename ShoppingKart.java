import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>(); // Store product prices
    private Map<String, Integer> cart = new LinkedHashMap<>(); // Maintain order of added items
    private TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>(); // Sort items by price

    // Add a product with its price
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Add item to cart
    public void addItemToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    // Display cart in the order items were added
    public void displayCartInOrder() {
        System.out.println("\nShopping Cart (Order of Addition):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " (x" + entry.getValue() + ")");
        }
    }

    // Display cart sorted by price
    public void displayCartSortedByPrice() {
        sortedByPrice.clear();

        // Group products by price
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            double price = productPrices.get(product);

            sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
        }

        System.out.println("\nShopping Cart (Sorted by Price):");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            double price = entry.getKey();
            for (String product : entry.getValue()) {
                System.out.println(product + " - $" + price);
            }
        }
    }

    // Calculate total cost
    public double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products and prices
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 0.75);
        cart.addProduct("Milk", 2.5);
        cart.addProduct("Bread", 2.0);

        // Adding items to cart
        cart.addItemToCart("Apple", 2);
        cart.addItemToCart("Milk", 1);
        cart.addItemToCart("Banana", 3);
        cart.addItemToCart("Bread", 1);

        // Display cart
        cart.displayCartInOrder();
        cart.displayCartSortedByPrice();

        // Total cost
        System.out.println("\nTotal Cost: $" + cart.calculateTotal());
    }
}
