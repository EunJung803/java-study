package chapter03;

public class StaticMethod {
	
	int n;			// 인스턴스 변수
	static int m;	// 클래스 변수
	
	/* 1) instance에서 static 쪽 접근하기 */
	void f1() {
		n = 10;
	}
	
	void f2() {
		// 아래 두개의 접근 다 가능
		StaticMethod.m = 10;
		// 같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능
		m = 20;
	}
	
	void f3() {
		f2();
	}
	
	void f4() {
		// 아래 두개의 접근 다 가능
		StaticMethod.s1();
		// 같은 클래스의 클래스(static) 메서드 접근에서는 클래스 이름 생략 가능
		s1();
	}
	
	/* 2) static에서 instance 쪽 접근하기 */
	static void s1() {
		// Error : static method 에서는 instance 변수 접근 불가 (아래 코드는 에러남)
		// n = 10;
	}
	
	static void s2() {
		// Error : static method 에서는 instance 메서드 접근 불가 (아래 코드는 에러남)
		// f1();
	}
	
	static void s3() {
		StaticMethod.m = 10;
		// 같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능 (내부라서 가능, 외부에서는 안됨)
		m = 10;
	}
	
	static void s4() {
		StaticMethod.s1();
		// 같은 클래스의 클래스(static) 메서드 접근에서는 클래스 이름 생략 가능 (내부라서 가능, 외부에서는 안됨)
		s1();
	}
 }
