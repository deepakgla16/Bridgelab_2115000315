import java.util.Scanner;

public class MaximumOfThreeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1, num2, num3, max;

        System.out.print("Enter the first number: ");
        num1 = input.nextInt();
        System.out.print("Enter the second number: ");
        num2 = input.nextInt();
        System.out.print("Enter the third number: ");
        num3 = input.nextInt();

        max = maximum(num1, num2, num3);

        System.out.println("The maximum of the three numbers is " + max + ".");

        input.close();
    }

    public static int maximum(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } 
        else if (b >= a && b >= c) {
            return b;
        } 
        else {
            return c;
        }
    }
}
