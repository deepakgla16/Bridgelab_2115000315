import java.util.Scanner;

public class FibonacciSequenceNumberGenerator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, first = 0, second = 1;

        System.out.print("Enter the number of terms you want to generate: ");
        n = input.nextInt();

        System.out.print("The first " + n + " terms of the Fibonacci sequence are: ");
        generateFibonacciSequence(n, first, second);
        input.close();
    }

    public static void generateFibonacciSequence(int n, int first, int second) {
        int next;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.print(first + " ");
                continue;
            }
            if (i == 2) {
                System.out.print(second + " ");
                continue;
            }
            next = first + second;
            first = second;
            second = next;
            System.out.print(next + " ");
        }
    }
}
