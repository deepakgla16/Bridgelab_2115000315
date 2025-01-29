import java.util.Scanner;

public class ReverseStringProgram {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		String reverseStr = reverse(str);
		System.out.printf("Reverse String is %s", reverseStr);
		input.close();
	}

	private static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
	
}
