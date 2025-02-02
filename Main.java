class Book {
    private String title;
    private String author;
    private double price;

    // Default constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

}
public class Main {
    public static void main(String[] args) {
        Book defaultBook = new Book();
        Book customBook = new Book("1984", "George Orwell", 9.99);

        System.out.println("Default Book: " + defaultBook.getTitle() + " by " + defaultBook.getAuthor() + ", Price: " + defaultBook.getPrice());
        System.out.println("Custom Book: " + customBook.getTitle() + " by " + customBook.getAuthor() + ", Price: " + customBook.getPrice());
    }
}
