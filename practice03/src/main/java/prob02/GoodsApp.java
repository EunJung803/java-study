package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for(int i=0; i<COUNT_GOODS; i++) {
			String input = scanner.nextLine();
			String[] splitInput = input.split(" ");
			
			goods[i].setName(splitInput[0]);
			goods[i].setPrice(Integer.parseInt(splitInput[1]));
			goods[i].setCountStock(Integer.parseInt(splitInput[2]));
			
		}

		// 상품 출력
		
		// 자원정리
		scanner.close();
	}
}
