package chapter04;

public class WrapperClassTest01 {
	
	public static void main(String[] args) {
		// 직접 생성하면 heap 상에 객체가 존재하게 된다.
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);

		// 리터럴(literal)을 사용하면 JVM안에 Constant Pool(상수 풀)에서 관리하게 된다.
		// Auto Boxing 
		Integer j1 = 10;
		Integer j2 = 20;
		
		System.out.println(j1 == j2);
		System.out.println(j1.equals(j2));
		
		// Auto Unboxing
		int m = j1 + 10;
//		int m = j1.intValue() + 10; 	// -> 이렇게 쓰지 말고 기본 타입처럼 쓰기
		
		
	}

}
