package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {
	
	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		
		// 잘못된 삽입 방식 (섞어서 사용)
//		v.addElement("둘리");
//		v.add("마이콜");
		
		// 삽입
		v.addElement("둘리");
		v.addElement("마이콜");
		v.addElement("또치");
		
		// 순회 1
		for(int i=0; i<v.size(); i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		
		// 삭제
		v.removeElementAt(2);
		
		
		// 순회 2 (가급적 사용 X)
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
		}

		
	}

}
