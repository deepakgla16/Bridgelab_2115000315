package Assignment2;
public class SpringSeason {

    // Method to check if the given date is in the Spring season
    public static boolean isSpringSeason(int month, int day) {
        // Check for Spring season: March 20 (inclusive) to June 20 (inclusive)
        if ((month == 3 && day >= 20 && day <= 31) || // March 20 to 31
            (month == 4 && day >= 1 && day <= 30) ||  // April
            (month == 5 && day >= 1 && day <= 31) ||  // May
            (month == 6 && day >= 1 && day <= 20)) {  // June 1 to 20
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Check if valid arguments are passed
        if (args.length < 2) {
            System.out.println("Please provide month and day as command-line arguments.");
            return;
        }

        try {
            // Parse the command-line arguments
            int month = Integer.parseInt(args[0]);
            int day = Integer.parseInt(args[1]);

            // Validate month and day
            if (month < 1 || month > 12 || day < 1 || day > 31) {
                System.out.println("Invalid month or day. Please provide valid inputs.");
                return;
            }

            // Check if it's a Spring season and print the result
            if (isSpringSeason(month, day)) {
                System.out.println("It's a Spring Season.");
            } else {
                System.out.println("Not a Spring Season.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please provide integer values for month and day.");
        }
    }
}
