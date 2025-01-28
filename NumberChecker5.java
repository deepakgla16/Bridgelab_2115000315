package Assignment2;
public class NumberChecker5 {

    // Method to find the factors of a number and return them as an array
    public static int[] findFactors(int number) {
        int count = 0;

        // Count how many factors the number has
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Store the factors in an array
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    // Method to find the greatest factor of a number
    public static int findGreatestFactor(int[] factors) {
        return factors[factors.length - 1];
    }

    // Method to find the sum of the factors
    public static int sumFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Method to find the product of the factors
    public static int productFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Method to find the product of the cube of the factors
    public static double productCubeFactors(int[] factors) {
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    // Method to check if a number is a perfect number
    public static boolean isPerfectNumber(int number) {
        int sumOfDivisors = sumFactors(findFactors(number)) - number; // Exclude the number itself
        return sumOfDivisors == number;
    }

    // Method to check if a number is an abundant number
    public static boolean isAbundantNumber(int number) {
        int sumOfDivisors = sumFactors(findFactors(number)) - number; // Exclude the number itself
        return sumOfDivisors > number;
    }

    // Method to check if a number is a deficient number
    public static boolean isDeficientNumber(int number) {
        int sumOfDivisors = sumFactors(findFactors(number)) - number; // Exclude the number itself
        return sumOfDivisors < number;
    }

    // Method to check if a number is a strong number
    public static boolean isStrongNumber(int number) {
        int sumOfFactorials = 0;
        int originalNumber = number;

        while (number > 0) {
            int digit = number % 10;
            sumOfFactorials += factorial(digit);
            number /= 10;
        }

        return sumOfFactorials == originalNumber;
    }

    // Helper method to calculate factorial of a digit
    private static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int number = 145;  // Example number for testing

        // Find the factors of the number
        int[] factors = findFactors(number);

        // Display the factors
        System.out.print("Factors of " + number + ": ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        // Find the greatest factor
        System.out.println("Greatest factor: " + findGreatestFactor(factors));

        // Find the sum of the factors
        System.out.println("Sum of factors: " + sumFactors(factors));

        // Find the product of the factors
        System.out.println("Product of factors: " + productFactors(factors));

        // Find the product of the cubes of the factors
        System.out.println("Product of cubes of factors: " + productCubeFactors(factors));

        // Check if the number is a perfect number
        System.out.println(number + " is a Perfect Number: " + isPerfectNumber(number));

        // Check if the number is an abundant number
        System.out.println(number + " is an Abundant Number: " + isAbundantNumber(number));

        // Check if the number is a deficient number
        System.out.println(number + " is a Deficient Number: " + isDeficientNumber(number));

        // Check if the number is a strong number
        System.out.println(number + " is a Strong Number: " + isStrongNumber(number));
    }
}
