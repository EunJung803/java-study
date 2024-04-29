package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();
		
		// 삽입 
		m.put("one", 1);	// auto boxing이 일어남
		m.put("two", 2);
		m.put("three", 3);
		
		// 접근
		int i = m.get("one");				// auto unboxing이 일어남
		int j = m.get(new String("one")); 	// 내용이 중요 (다른 객체도 가능)
		
		System.out.println(i + " : " + j);
		
		m.put("three", 333);
		System.out.println(m.get("three"));	// 같은 key에 또 삽입되면 값이 덮어씌워짐
		
		// 순회 (map도 keySet을 통해서 간접적으로 순회 가능)
		Set<String> s = m.keySet();
		for(String key : s) {
			System.out.println(m.get(key));
		}
		
	}

}
