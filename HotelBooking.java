class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    // Default constructor
    public HotelBooking() {
        this("Unknown", "Standard", 1);
    }

    // Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    // Getter methods
    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNights() {
        return nights;
    }

    public static void main(String[] args) {
        HotelBooking defaultBooking = new HotelBooking();
        HotelBooking customBooking = new HotelBooking("John Doe", "Deluxe", 3);
        HotelBooking copiedBooking = new HotelBooking(customBooking);

        System.out.println("Default Booking: " + defaultBooking.getGuestName() + ", Room: " + defaultBooking.getRoomType() + ", Nights: " + defaultBooking.getNights());
        System.out.println("Custom Booking: " + customBooking.getGuestName() + ", Room: " + customBooking.getRoomType() + ", Nights: " + customBooking.getNights());
        System.out.println("Copied Booking: " + copiedBooking.getGuestName() + ", Room: " + copiedBooking.getRoomType() + ", Nights: " + copiedBooking.getNights());
    }
}