import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManagementSystem {
    private Movie head = null;
    private Movie tail = null;

    // Add movie at the beginning
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add movie at the end
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add movie at a specific position
    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 0) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            addMovieAtEnd(title, director, year, rating);
        } else {
            newMovie.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newMovie;
            }
            temp.next = newMovie;
            newMovie.prev = temp;

            if (newMovie.next == null) {
                tail = newMovie;
            }
        }
    }

    // Remove movie by title
    public void removeMovie(String title) {
        if (head == null) {
            System.out.println("Movie list is empty.");
            return;
        }

        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie '" + title + "' removed successfully.");
    }

    // Search for movies by Director
    public void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println("Title: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found by director '" + director + "'.");
        }
    }

    // Search for movies by Rating
    public void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Title: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found with rating " + rating);
        }
    }

    // Update Movie Rating
    public void updateMovieRating(String title, double newRating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Updated Rating for '" + title + "' to " + newRating);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie '" + title + "' not found.");
    }

    // Display movies in forward order
    public void displayMoviesForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }

        Movie temp = head;
        System.out.println("\nMovies (Forward Order):");
        while (temp != null) {
            System.out.println("Title: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display movies in reverse order
    public void displayMoviesReverse() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }

        Movie temp = tail;
        System.out.println("\nMovies (Reverse Order):");
        while (temp != null) {
            System.out.println("Title: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

// Driver Code
public class MovieManagement {
    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMovie Management System:");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Movies (Forward)");
            System.out.println("9. Display Movies (Reverse)");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    mms.addMovieAtBeginning(scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    mms.addMovieAtEnd(scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter Title, Director, Year, Rating, Position: ");
                    mms.addMovieAtPosition(scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextDouble(), scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Movie Title to Remove: ");
                    mms.removeMovie(scanner.next());
                    break;
                case 5:
                    System.out.print("Enter Director Name: ");
                    mms.searchByDirector(scanner.next());
                    break;
                case 6:
                    System.out.print("Enter Rating: ");
                    mms.searchByRating(scanner.nextDouble());
                    break;
                case 7:
                    System.out.print("Enter Title & New Rating: ");
                    mms.updateMovieRating(scanner.next(), scanner.nextDouble());
                    break;
                case 8:
                    mms.displayMoviesForward();
                    break;
                case 9:
                    mms.displayMoviesReverse();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
