package Assignment2;
public class NumberChecker4 {

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a number is a neon number
    public static boolean isNeon(int number) {
        int square = number * number;
        int sumOfDigits = 0;

        // Sum the digits of the square of the number
        while (square > 0) {
            sumOfDigits += square % 10;
            square /= 10;
        }

        return sumOfDigits == number;
    }

    // Method to check if a number is a spy number
    public static boolean isSpyNumber(int number) {
        int sumOfDigits = 0;
        int productOfDigits = 1;
        int originalNumber = number;

        while (number > 0) {
            int digit = number % 10;
            sumOfDigits += digit;
            productOfDigits *= digit;
            number /= 10;
        }

        return sumOfDigits == productOfDigits;
    }

    // Method to check if a number is an automorphic number
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    // Method to check if a number is a buzz number
    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || String.valueOf(number).endsWith("7");
    }

    public static void main(String[] args) {
        int number = 25;  // Example number for testing

        // Check if the number is prime
        System.out.println(number + " is Prime: " + isPrime(number));

        // Check if the number is neon
        System.out.println(number + " is Neon: " + isNeon(number));

        // Check if the number is a spy number
        System.out.println(number + " is Spy: " + isSpyNumber(number));

        // Check if the number is automorphic
        System.out.println(number + " is Automorphic: " + isAutomorphic(number));

        // Check if the number is buzz number
        System.out.println(number + " is Buzz: " + isBuzzNumber(number));
    }
}
