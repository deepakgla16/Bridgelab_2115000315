import java.util.Scanner;

public class FactorialUsingRecursion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;

        System.out.print("Enter a number: ");
        number = input.nextInt();

        System.out.println("The factorial of " + number + " is " + factorial(number) + ".");

        input.close();
    }

    public static int factorial(int n) {
        if (n <= 0) {
            return 1;
        } 
          return n * factorial(n - 1);
    }
}

