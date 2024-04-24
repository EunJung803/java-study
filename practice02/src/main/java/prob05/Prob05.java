package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while( true ) {
			
			/* 게임 작성 */

			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
//			System.out.println(correctNumber);
			
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			System.out.println("1-100");
			
			int currMax = 100;
			int currMin = 1;

			int cnt = 1;
			
			while(true) {
				System.out.print(cnt + ">>");
				int input = scanner.nextInt();
				
				if(input < correctNumber) {
					System.out.println("더 높게");
					System.out.println(input + "-" + currMax);
					currMin = input;
				}
					
				else if(input > correctNumber) {
					System.out.println("더 낮게");
					System.out.println(currMin + "-" + input);
					currMax = input;
				}
				
				else {
					System.out.println("맞았습니다.");
					break;
				}
				cnt ++;
				
			}
			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}
		
		scanner.close();
	}

}