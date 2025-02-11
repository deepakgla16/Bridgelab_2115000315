import java.time.LocalDateTime;
import java.util.Scanner;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = LocalDateTime.now();
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;
    private int ticketCount = 0;

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber);
        
        if (head == null) {
            head = tail = newTicket;
            tail.next = head; // Make it circular
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Maintain circular nature
        }
        ticketCount++;
        System.out.println("Ticket booked successfully!");
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head, prev = tail;
        do {
            if (current.ticketID == ticketID) {
                if (current == head) { // Removing the first ticket
                    head = head.next;
                    tail.next = head; // Maintain circular nature
                } else if (current == tail) { // Removing the last ticket
                    tail = prev;
                    tail.next = head; // Maintain circular nature
                } else { // Removing from the middle
                    prev.next = current.next;
                }
                ticketCount--;
                System.out.println("Ticket with ID " + ticketID + " removed successfully.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket ID not found.");
    }

    // Display all tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = head;
        System.out.println("\nCurrent Ticket Reservations:");
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + 
                    ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        boolean found = false;
        Ticket current = head;
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                        ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No ticket found for query: " + query);
        }
    }

    // Count total number of booked tickets
    public int countTickets() {
        return ticketCount;
    }
}

// Driver Code
public class OnlineTicketReservationSystem {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOnline Ticket Reservation System:");
            System.out.println("1. Add a New Ticket");
            System.out.println("2. Remove a Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search for a Ticket");
            System.out.println("5. Count Total Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int ticketID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movieName = scanner.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seatNumber = scanner.nextLine();
                    system.addTicket(ticketID, customerName, movieName, seatNumber);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    int removeID = scanner.nextInt();
                    system.removeTicket(removeID);
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name or Movie Name to search: ");
                    String query = scanner.nextLine();
                    system.searchTicket(query);
                    break;
                case 5:
                    System.out.println("Total booked tickets: " + system.countTickets());
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
