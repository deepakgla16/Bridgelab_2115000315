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
		String result = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}
		return result;

	}

}
