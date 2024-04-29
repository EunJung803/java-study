package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {
	
	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		
		String s1 = "둘리";
		
		// 삽입
		s.add("둘리");
		s.add("마이콜");
		s.add("또치");
		s.add(s1);		// 내용으로 하는거라 중복 허용 X, 안들어감
		
		// get은 못함
		System.out.println(s.size());
		System.out.println(s.contains("둘리"));		// 값처럼 들어있는 거라서 객체를 넣어서 이게 들어있는지 찾기 가능
		System.out.println(s.contains(s1));			// 내부에서 해시코드 값 으로 비교
		
		// 순회 
		for(String str : s) {
			System.out.println(str);
		}
		
		
	}

}
