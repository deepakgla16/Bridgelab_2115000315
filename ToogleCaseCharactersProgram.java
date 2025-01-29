import java.util.Scanner;

public class ToogleCaseCharactersProgram {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		String toogleCasedString = toogleCase(str);
		System.out.printf("\"%s\" after toogle case on characters becomes \"%s\"", str, toogleCasedString);
		input.close();
	}

	private static String toogleCase(String str) {
		char[] strToCharArray = str.toCharArray();
		for(int i=0; i<strToCharArray.length; i++) {
			int charAscii = strToCharArray[i];
			if(charAscii >= 65 && charAscii <= 90) {
				charAscii += 32;
			}
			else if(charAscii >= 97 && charAscii <= 122) {
				charAscii -= 32;
			}
			strToCharArray[i] = (char)charAscii;
		}
		
		return new String(strToCharArray);
	}
}
