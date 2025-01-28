package Assignment2;
import java.util.Arrays;

public class OTPGenerator {

    // Method to generate a 6-digit OTP number
    public static int generateOTP() {
        // Math.random() generates a value between 0.0 (inclusive) and 1.0 (exclusive)
        // Multiply it by 900000 and add 100000 to ensure the range is between 100000 and 999999
        return (int) (Math.random() * 900000) + 100000;
    }

    // Method to ensure the OTP numbers generated are unique
    public static boolean areOTPsUnique(int[] otps) {
        // Sort the OTP array to compare adjacent elements
        Arrays.sort(otps);

        // Compare adjacent OTPs to check if there are duplicates
        for (int i = 0; i < otps.length - 1; i++) {
            if (otps[i] == otps[i + 1]) {
                return false; // Duplicate found, return false
            }
        }

        return true; // No duplicates found, return true
    }

    public static void main(String[] args) {
        int[] otps = new int[10];

        // Generate OTPs 10 times and store them in the array
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
        }

        // Display the OTPs
        System.out.println("Generated OTPs:");
        for (int otp : otps) {
            System.out.println(otp);
        }

        // Check if the OTPs are unique
        boolean areUnique = areOTPsUnique(otps);
        if (areUnique) {
            System.out.println("All OTPs are unique!");
        } else {
            System.out.println("Duplicate OTPs found!");
        }
    }
}
