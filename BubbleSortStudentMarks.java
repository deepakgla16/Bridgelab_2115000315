import java.util.Arrays;

public class BubbleSortStudentMarks {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks[j + 1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the last pass, the array is sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] studentMarks = {78, 92, 45, 88, 67, 55, 89};
        System.out.println("Original Marks: " + Arrays.toString(studentMarks));
        
        bubbleSort(studentMarks);
        
        System.out.println("Sorted Marks: " + Arrays.toString(studentMarks));
    }
}
