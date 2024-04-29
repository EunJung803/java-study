package collection;

import java.util.Stack;

public class StackTest {
	
	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		// 삽입
		s.push("둘리");
		s.push("마이콜");
		s.push("또치");
		
		// 뽑기
		while(!s.isEmpty()) {
			String str = s.pop();
			System.out.println(str);
		}
		
		// 비어있는 경우 예외
		// s.pop();

		s.push("둘리");
		s.push("마이콜");
		s.push("또치");
		
		System.out.println(s.pop());
		System.out.println(s.peek());	// 맨 위에 뭐가 있는지만 보고 뽑아내진 않음
		System.out.println(s.pop());
		
	}

}
