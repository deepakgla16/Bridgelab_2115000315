import java.util.Scanner;
public class CountVowelsAndConsonantsProgram {
	private static int[] count(String str) {
		int countVowels = 0;
		int countConsonants = 0;
		str = str.toLowerCase();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u')
				countVowels++;
			else{
				countConsonants++;
			}
		}
		return new int[]{countVowels, countConsonants};
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		int[] vowelsAndConsonantsCount = count(str);
		int countVowels = vowelsAndConsonantsCount[0];
		int countConsonants = vowelsAndConsonantsCount[1];
		System.out.printf("In Given String: %s\nThere are %d vowels and %d consonants.", str, countVowels, countConsonants);
		input.close();
	}
}
