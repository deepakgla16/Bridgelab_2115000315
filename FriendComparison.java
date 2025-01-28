package Assignment2;
import java.util.Scanner;

public class FriendComparison {

    // Method to find the youngest of the 3 friends
    public static String findYoungest(int[] ages, String[] names) {
        int minAge = ages[0];
        String youngestFriend = names[0];
        
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngestFriend = names[i];
            }
        }
        return youngestFriend;
    }

    // Method to find the tallest of the 3 friends
    public static String findTallest(double[] heights, String[] names) {
        double maxHeight = heights[0];
        String tallestFriend = names[0];
        
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallestFriend = names[i];
            }
        }
        return tallestFriend;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Arrays to store the names, ages, and heights of the friends
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        // Input the ages and heights for the 3 friends
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the age of " + names[i] + ": ");
            ages[i] = scanner.nextInt();
            
            System.out.print("Enter the height (in cm) of " + names[i] + ": ");
            heights[i] = scanner.nextDouble();
        }
        
        // Find the youngest friend
        String youngest = findYoungest(ages, names);
        System.out.println("The youngest friend is: " + youngest);
        
        // Find the tallest friend
        String tallest = findTallest(heights, names);
        System.out.println("The tallest friend is: " + tallest);
        
        scanner.close();
    }
}
