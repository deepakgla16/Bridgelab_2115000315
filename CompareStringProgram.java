import java.util.Scanner;

public class CompareStringProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first & second string respectively: ");
        String str1 = input.nextLine();
        String str2 = input.nextLine();

        int order = str1.compareTo(str2);
		if(order <= -1){
			System.out.printf("\"%s\" comes before \"%s\" in lexicographical order", str1, str2);
        }
		else if(order >= 1){
			System.out.printf("\"%s\" comes after \"%s\" in lexicographical order", str1, str2);
        }
		else{
			System.out.printf("\"%s\" comes on same place \"%s\" in lexicographical order since they are equal", str1, str2);
        }
        input.close();
    }
}
