class Book {
    // Static variable shared across all books
    private static String libraryName = "Central Library";

    // Instance variables
    private String title;
    private String author;
    private final String isbn; // Final to ensure immutability

    // Constructor using 'this' to resolve ambiguity
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method to display the library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details (checking instanceof)
    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Library: " + libraryName);
            System.out.println("Title: " + this.title);
            System.out.println("Author: " + this.author);
            System.out.println("ISBN: " + this.isbn);
        } else {
            System.out.println("Invalid book object.");
        }
    }

    public static void main(String[] args) {
        // Display the library name
        Book.displayLibraryName();

        // Creating Book objects
        Book book1 = new Book("1984", "George Orwell", "978-0451524935");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");

        // Displaying book details
        book1.displayBookDetails();
        book2.displayBookDetails();
    }
}
