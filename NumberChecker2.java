package Assignment2;
public class NumberChecker2 {

    // Method to find the count of digits in the number
    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    // Method to store the digits of the number in an array
    public static int[] storeDigits(int number) {
        String numStr = String.valueOf(number);
        int[] digits = new int[numStr.length()];

        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';  // Convert char to int
        }

        return digits;
    }

    // Method to find the sum of the digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    // Method to find the sum of the squares of the digits
    public static double sumOfSquaresOfDigits(int[] digits) {
        double sumOfSquares = 0;
        for (int digit : digits) {
            sumOfSquares += Math.pow(digit, 2);  // Square each digit and add it to sum
        }
        return sumOfSquares;
    }

    // Method to check if the number is a Harshad number
    public static boolean isHarshadNumber(int number, int[] digits) {
        int sumOfDigits = sumOfDigits(digits);
        return number % sumOfDigits == 0;
    }

    // Method to find the frequency of each digit
    public static int[][] findDigitFrequency(int[] digits) {
        int[][] frequency = new int[10][2];  // Array to store frequency of digits 0-9

        // Initialize the frequency array
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;  // The digit (0 to 9)
            frequency[i][1] = 0;   // Initial frequency is 0
        }

        // Count the frequency of each digit
        for (int digit : digits) {
            frequency[digit][1]++;  // Increment the frequency of the digit
        }

        return frequency;
    }

    // Method to display frequency of digits
    public static void displayFrequency(int[][] frequency) {
        System.out.println("Digit | Frequency");
        for (int i = 0; i < 10; i++) {
            if (frequency[i][1] > 0) {
                System.out.println(frequency[i][0] + "     | " + frequency[i][1]);
            }
        }
    }

    public static void main(String[] args) {
        int number = 21;  // Example number for testing

        // Store the digits of the number
        int[] digits = storeDigits(number);

        // Count the digits
        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);

        // Sum of digits
        int sum = sumOfDigits(digits);
        System.out.println("Sum of digits: " + sum);

        // Sum of squares of digits
        double sumOfSquares = sumOfSquaresOfDigits(digits);
        System.out.println("Sum of squares of digits: " + sumOfSquares);

        // Check if the number is a Harshad number
        boolean isHarshad = isHarshadNumber(number, digits);
        System.out.println("Is Harshad Number: " + isHarshad);

        // Find and display the frequency of digits
        int[][] frequency = findDigitFrequency(digits);
        displayFrequency(frequency);
    }
}
