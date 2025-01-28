package Assignment2;
import java.util.Random;

public class FootballTeamHeight {

    // Method to generate random heights for the football team players (between 150 cm to 250 cm)
    public static int[] generateHeights(int size) {
        Random random = new Random();
        int[] heights = new int[size];

        // Generate random heights for each player between 150 and 250
        for (int i = 0; i < size; i++) {
            heights[i] = random.nextInt(101) + 150; // Random height between 150 and 250
        }

        return heights;
    }

    // Method to find the sum of all elements in the array (heights)
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    // Method to find the mean height of the players
    public static double findMeanHeight(int[] heights) {
        int sum = findSum(heights);
        return (double) sum / heights.length; // Mean = sum / number of players
    }

    // Method to find the shortest height (minimum value)
    public static int findShortestHeight(int[] heights) {
        int min = heights[0];
        for (int height : heights) {
            if (height < min) {
                min = height;
            }
        }
        return min;
    }

    // Method to find the tallest height (maximum value)
    public static int findTallestHeight(int[] heights) {
        int max = heights[0];
        for (int height : heights) {
            if (height > max) {
                max = height;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int teamSize = 11; // Number of players in the football team
        int[] heights = generateHeights(teamSize);

        // Print the heights of the players
        System.out.println("Heights of the football team players:");
        for (int height : heights) {
            System.out.print(height + " ");
        }
        System.out.println();

        // Calculate and display the shortest, tallest, and mean height
        int shortestHeight = findShortestHeight(heights);
        int tallestHeight = findTallestHeight(heights);
        double meanHeight = findMeanHeight(heights);

        System.out.println("Shortest Height: " + shortestHeight + " cm");
        System.out.println("Tallest Height: " + tallestHeight + " cm");
        System.out.println("Mean Height: " + meanHeight + " cm");
    }
}
