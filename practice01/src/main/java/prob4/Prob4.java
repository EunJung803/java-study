package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		
		String newText = "";
		for(int i=0; i<text.length(); i++) {
			newText += text.charAt(i);
			System.out.println(newText);
		}

		
		scanner.close();
	}

}
