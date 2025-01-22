package Assignment2;

public class code2 {
    public static void main(String[] args) {
        // Marks in individual subjects
        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        // Total marks and maximum possible marks
        int totalMarks = maths + physics + chemistry;
        int maxMarks = 300; // Each subject out of 100

        // Calculate average percentage
        double averagePercentage = (totalMarks / (double) maxMarks) * 100;

        // Output the result
        System.out.println(averagePercentage);
    }
}
