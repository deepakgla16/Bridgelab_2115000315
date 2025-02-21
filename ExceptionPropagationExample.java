public class ExceptionPropagationExample {
    // Method that throws an exception if input is invalid
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return (amount * rate * years) / 100; // Simple Interest Formula
    }

    public static void main(String[] args) {
        try {
            // Valid case
            System.out.println("Interest: " + calculateInterest(1000, 5, 2));

            // Invalid case - throws exception
            System.out.println("Interest: " + calculateInterest(-500, 5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Handle exception
        }
    }
}
