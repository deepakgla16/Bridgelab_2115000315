// Abstract class representing a Library Item
abstract class LibraryItem {
    protected String itemId;
    protected String title;
    protected String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Abstract method to get loan duration
    public abstract int getLoanDuration();

    // Concrete method to get item details
    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    // Getters
    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}

// Interface for reservable items
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Book class extending LibraryItem and implementing Reservable
class Book extends LibraryItem implements Reservable {
    private static final int LOAN_DURATION = 14; // 14 days loan period
    private boolean isAvailable = true;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return LOAN_DURATION;
    }

    @Override
    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book reserved: " + title);
        } else {
            System.out.println("Book is currently unavailable: " + title);
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// Magazine class extending LibraryItem (not reservable)
class Magazine extends LibraryItem {
    private static final int LOAN_DURATION = 7; // 7 days loan period

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return LOAN_DURATION;
    }
}

// DVD class extending LibraryItem and implementing Reservable
class DVD extends LibraryItem implements Reservable {
    private static final int LOAN_DURATION = 5; // 5 days loan period
    private boolean isAvailable = true;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return LOAN_DURATION;
    }

    @Override
    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD reserved: " + title);
        } else {
            System.out.println("DVD is currently unavailable: " + title);
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// Main class to demonstrate polymorphism
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Magazine("M001", "National Geographic", "Various"),
            new DVD("D001", "Inception", "Christopher Nolan")
        };

        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            
            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem();
            }
            System.out.println("-----------------------------------");
        }
    }
}
