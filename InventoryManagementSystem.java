import java.util.Scanner;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagement {
    private Item head = null;

    // Add item at the beginning
    public void addItemAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add item at the end
    public void addItemAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    // Add item at a specific position
    public void addItemAtPosition(String name, int id, int quantity, double price, int position) {
        if (position <= 0) {
            addItemAtBeginning(name, id, quantity, price);
            return;
        }

        Item newItem = new Item(name, id, quantity, price);
        Item temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            addItemAtEnd(name, id, quantity, price);
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    // Remove item by Item ID
    public void removeItem(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.id == id) {
            head = head.next;
            System.out.println("Item with ID " + id + " removed.");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item with ID " + id + " removed.");
        }
    }

    // Update item quantity by Item ID
    public void updateQuantity(int id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search item by Item ID
    public void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println("Found: " + temp.name + " | ID: " + temp.id + " | Qty: " + temp.quantity + " | Price: $" + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search item by Item Name
    public void searchByName(String name) {
        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + temp.name + " | ID: " + temp.id + " | Qty: " + temp.quantity + " | Price: $" + temp.price);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;

        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Display inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        Item temp = head;
        System.out.println("\nInventory List:");
        while (temp != null) {
            System.out.println(temp.name + " | ID: " + temp.id + " | Qty: " + temp.quantity + " | Price: $" + temp.price);
            temp = temp.next;
        }
    }

    // Sort inventory by name (Bubble Sort)
    public void sortByName() {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            Item temp = head;
            while (temp.next != null) {
                if (temp.name.compareTo(temp.next.name) > 0) {
                    swap(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        System.out.println("Inventory sorted by name.");
    }

    // Sort inventory by price (Bubble Sort)
    public void sortByPrice() {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            Item temp = head;
            while (temp.next != null) {
                if (temp.price > temp.next.price) {
                    swap(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        System.out.println("Inventory sorted by price.");
    }

    // Swap function for sorting
    private void swap(Item a, Item b) {
        String tempName = a.name;
        int tempId = a.id;
        int tempQuantity = a.quantity;
        double tempPrice = a.price;

        a.name = b.name;
        a.id = b.id;
        a.quantity = b.quantity;
        a.price = b.price;

        b.name = tempName;
        b.id = tempId;
        b.quantity = tempQuantity;
        b.price = tempPrice;
    }
}

// Driver Code
public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System:");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Item Quantity");
            System.out.println("6. Search Item by ID");
            System.out.println("7. Search Item by Name");
            System.out.println("8. Calculate Total Value");
            System.out.println("9. Display Inventory");
            System.out.println("10. Sort Inventory by Name");
            System.out.println("11. Sort Inventory by Price");
            System.out.println("12. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    inventory.addItemAtBeginning(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextDouble());
                    break;
                case 2:
                    inventory.addItemAtEnd(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextDouble());
                    break;
                case 3:
                    inventory.addItemAtPosition(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextDouble(), scanner.nextInt());
                    break;
                case 4:
                    inventory.removeItem(scanner.nextInt());
                    break;
                case 5:
                    inventory.updateQuantity(scanner.nextInt(), scanner.nextInt());
                    break;
                case 6:
                    inventory.searchById(scanner.nextInt());
                    break;
                case 7:
                    inventory.searchByName(scanner.next());
                    break;
                case 8:
                    inventory.calculateTotalValue();
                    break;
                case 9:
                    inventory.displayInventory();
                    break;
                case 10:
                    inventory.sortByName();
                    break;
                case 11:
                    inventory.sortByPrice();
                    break;
                case 12:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
