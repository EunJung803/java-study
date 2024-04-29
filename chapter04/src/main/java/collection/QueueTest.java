package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();		// LinkedList가 Queue 인터페이스를 구현하고 있음
		// 이걸 List로 레퍼런싱하면 리스트로 사용, Queue로 레퍼런싱하면 큐로 사용
		
		// 삽입
		q.offer("마이콜");
		q.offer("둘리");
		q.offer("또치");
		
		// 뽑기
		while(!q.isEmpty()) {
			String s = q.poll();
			System.out.println(s);
		}
		
		System.out.println(q.poll());		// 예외가 터지지 않고 null이 나옴 (비어있을 때 뽑으면)
		
		q.offer("마이콜");
		q.offer("둘리");
		q.offer("또치");
		
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.poll());
		
	}

}
