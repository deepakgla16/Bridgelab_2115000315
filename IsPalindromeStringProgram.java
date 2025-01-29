import java.util.Scanner;

public class IsPalindromeStringProgram {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		if(checkPalindrom(str)){
			System.out.printf("%s is a Palindrom String", str);
		}
		else{
			System.out.printf("%s is not a Palindrom String", str);
		}
		input.close();
	}

	public static boolean checkPalindrom(String str) {
		int left = 0;
		int right = str.length() - 1;
		while(left < right) {
			if(str.charAt(left) != str.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
