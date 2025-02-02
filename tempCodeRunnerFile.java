// Book.java
class Book {
    // Attributes with appropriate access modifiers
    public String ISBN;
    protected String title;
    private String author;

    // Constructor to initialize the book details
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public method to access author
    public String getAuthor() {
        return author;
    }

    // Public method to modify author name
    public void setAuthor(String author) {
        this.author = author;
    }
}

// EBook.java
class EBook extends Book {
    // Constructor to initialize the EBook details
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    // Method to display ISBN and title, demonstrating access to protected members
    public void displayEBookDetails() {
        System.out.println("EBook ISBN: " + ISBN);    // Accessing public member ISBN
        System.out.println("EBook Title: " + title);  // Accessing protected member title
    }
}

// Main.java
public class BookLibrarySystem {
    public static void main(String[] args) {
        // Creating an instance of Book
        Book book1 = new Book("978-0135166307", "Effective Java", "Joshua Bloch");
        System.out.println("Book Author: " + book1.getAuthor());

        // Modifying author name using the public method
        book1.setAuthor("James Gosling");
        System.out.println("Updated Book Author: " + book1.getAuthor());

        // Creating an instance of EBook
        EBook eBook1 = new EBook("978-0201633610", "Design Patterns", "Erich Gamma");
        eBook1.displayEBookDetails();
    }
}
