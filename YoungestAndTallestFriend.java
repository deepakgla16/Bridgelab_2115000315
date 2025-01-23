package Assignment2;
import java.util.Scanner;

public class YoungestAndTallestFriend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for age and height of Amar
        System.out.print("Enter the age of Amar: ");
        int ageAmar = scanner.nextInt();
        System.out.print("Enter the height of Amar (in cm): ");
        int heightAmar = scanner.nextInt();

        // Take input for age and height of Akbar
        System.out.print("Enter the age of Akbar: ");
        int ageAkbar = scanner.nextInt();
        System.out.print("Enter the height of Akbar (in cm): ");
        int heightAkbar = scanner.nextInt();

        // Take input for age and height of Anthony
        System.out.print("Enter the age of Anthony: ");
        int ageAnthony = scanner.nextInt();
        System.out.print("Enter the height of Anthony (in cm): ");
        int heightAnthony = scanner.nextInt();

        // Find the youngest friend by comparing ages
        int youngestAge = ageAmar;
        String youngestFriend = "Amar";
        if (ageAkbar < youngestAge) {
            youngestAge = ageAkbar;
            youngestFriend = "Akbar";
        }
        if (ageAnthony < youngestAge) {
            youngestAge = ageAnthony;
            youngestFriend = "Anthony";
        }

        // Find the tallest friend by comparing heights
        int tallestHeight = heightAmar;
        String tallestFriend = "Amar";
        if (heightAkbar > tallestHeight) {
            tallestHeight = heightAkbar;
            tallestFriend = "Akbar";
        }
        if (heightAnthony > tallestHeight) {
            tallestHeight = heightAnthony;
            tallestFriend = "Anthony";
        }

        // Display the results
        System.out.println("The youngest friend is " + youngestFriend + " with age " + youngestAge + ".");
        System.out.println("The tallest friend is " + tallestFriend + " with height " + tallestHeight + " cm.");

        scanner.close();
    }
}
