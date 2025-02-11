import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagement {
    private Book head = null;
    private Book tail = null;
    private int totalBooks = 0;

    // Add book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        totalBooks++;
    }

    // Add book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        totalBooks++;
    }

    // Add book at a specific position
    public void addBookAtPosition(String title, String author, String genre, int bookID, boolean isAvailable, int position) {
        if (position <= 0) {
            addBookAtBeginning(title, author, genre, bookID, isAvailable);
            return;
        }

        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        Book temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            addBookAtEnd(title, author, genre, bookID, isAvailable);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newBook;
            } else {
                tail = newBook;
            }
            temp.next = newBook;
        }
        totalBooks++;
    }

    // Remove book by Book ID
    public void removeBook(int bookID) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        if (head.bookID == bookID) {
            head = head.next;
            if (head != null) head.prev = null;
            totalBooks--;
            System.out.println("Book with ID " + bookID + " removed.");
            return;
        }

        Book temp = head;
        while (temp != null && temp.bookID != bookID) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found.");
        } else {
            if (temp.next != null) temp.next.prev = temp.prev;
            if (temp.prev != null) temp.prev.next = temp.next;
            if (temp == tail) tail = temp.prev;
            totalBooks--;
            System.out.println("Book with ID " + bookID + " removed.");
        }
    }

    // Search book by Title
    public void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + temp.title + " | ID: " + temp.bookID + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Available: " + temp.isAvailable);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Search book by Author
    public void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Found: " + temp.title + " | ID: " + temp.bookID + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Available: " + temp.isAvailable);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Update book's availability status
    public void updateAvailability(int bookID, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.isAvailable = status;
                System.out.println("Availability updated for Book ID " + bookID);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    // Display books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book temp = head;
        System.out.println("\nBooks in Library:");
        while (temp != null) {
            System.out.println(temp.title + " | ID: " + temp.bookID + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    // Display books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book temp = tail;
        System.out.println("\nBooks in Reverse Order:");
        while (temp != null) {
            System.out.println(temp.title + " | ID: " + temp.bookID + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    // Count total number of books
    public int getTotalBooks() {
        return totalBooks;
    }
}

// Driver Code
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Books (Forward)");
            System.out.println("9. Display Books (Reverse)");
            System.out.println("10. Count Total Books");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    library.addBookAtBeginning(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextBoolean());
                    break;
                case 2:
                    library.addBookAtEnd(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextBoolean());
                    break;
                case 3:
                    library.addBookAtPosition(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextBoolean(), scanner.nextInt());
                    break;
                case 4:
                    library.removeBook(scanner.nextInt());
                    break;
                case 5:
                    library.searchByTitle(scanner.next());
                    break;
                case 6:
                    library.searchByAuthor(scanner.next());
                    break;
                case 7:
                    library.updateAvailability(scanner.nextInt(), scanner.nextBoolean());
                    break;
                case 8:
                    library.displayBooksForward();
                    break;
                case 9:
                    library.displayBooksReverse();
                    break;
                case 10:
                    System.out.println("Total Books: " + library.getTotalBooks());
                    break;
                case 11:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
