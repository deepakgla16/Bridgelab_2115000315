class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    // Default constructor
    public LibraryBook() {
        this("Unknown", "Unknown", 0.0, true);
    }

    // Parameterized constructor
    public LibraryBook(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Method to borrow a book
    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        } else {
            return false;
        }
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("1984", "George Orwell", 9.99, true);
        System.out.println("Borrowing '1984': " + (book1.borrowBook() ? "Successful" : "Unavailable"));
        System.out.println("Borrowing '1984' again: " + (book1.borrowBook() ? "Successful" : "Unavailable"));
    }
}
