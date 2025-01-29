import java.util.Scanner;

public class GCDAndLCMCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1, num2, gcd, lcm;

        System.out.print("Enter the first number: ");
        num1 = input.nextInt();
        System.out.print("Enter the second number: ");
        num2 = input.nextInt();

        gcd = GCD(num1, num2);
        lcm = LCM(num1, num2, gcd);

        System.out.println("The GCD of " + num1 + " and " + num2 + " is " + gcd + ".");
        System.out.println("The LCM of " + num1 + " and " + num2 + " is " + lcm + ".");

        input.close();
    }

    public static int GCD(int divisor, int dividend){
        while(dividend % divisor != 0){
            int rem = dividend % divisor;
            dividend = divisor;
            divisor = rem;
        }
        return divisor;
    }

    public static int LCM(int num1, int num2, int gcd){
        return (num1 * num2) / gcd;
    }
}
