package Assignment2;

public class code5
 {
    public static void main(String[] args) {
        // Total pens and students
        int totalPens = 14;
        int totalStudents = 3;

        // Calculate pens per student and remaining pens
        int pensPerStudent = totalPens / totalStudents;
        int remainingPens = totalPens % totalStudents;

        // Output the results
        System.out.printf(
            "The Pen Per Student is %d and the remaining pen not distributed is %d\n",
            pensPerStudent, remainingPens
        );
    }
}
