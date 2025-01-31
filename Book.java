// Book class to store and display book details
class BookDetail {
    private String title;
    private String author;
    private double price;

    // Constructor to initialize Book attributes
    public BookDetail(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
}
    // Main method to test the Book class
    public class Book{
    public static void main(String[] args) {
        // Creating a Book object
        BookDetail book1 = new BookDetail("The Great Gatsby", "F. Scott Fitzgerald", 10.99);

        // Displaying book details
        book1.displayDetails();
    }
}
