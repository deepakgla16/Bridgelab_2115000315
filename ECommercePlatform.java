import java.util.ArrayList;
import java.util.List;


class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}


class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId + " placed by " + customer.getName());
        System.out.println("Products in this order:");
        double total = 0;
        for (Product product : products) {
            System.out.println("  - " + product.getName() + " ($" + product.getPrice() + ")");
            total += product.getPrice();
        }
        System.out.println("Total Price: $" + total);
    }
}


class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void showOrders() {
        System.out.println(name + "'s Orders:");
        for (Order order : orders) {
            order.showOrderDetails();
            System.out.println();
        }
    }
}


public class ECommercePlatform {
    public static void main(String[] args) {
        
        Product p1 = new Product("Laptop", 800.00);
        Product p2 = new Product("Smartphone", 500.00);
        Product p3 = new Product("Headphones", 150.00);

        
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        
        Order order1 = new Order(1, customer1);
        order1.addProduct(p1);
        order1.addProduct(p2);
        customer1.placeOrder(order1);

        Order order2 = new Order(2, customer2);
        order2.addProduct(p3);
        customer2.placeOrder(order2);

        
        System.out.println();
        customer1.showOrders();
        customer2.showOrders();
    }
}
