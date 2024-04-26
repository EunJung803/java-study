package exception;

import java.io.IOException;

public class MyClass {
	
	public void danger() throws IOException, MyException {
		System.out.println("some code 1 ...");
		System.out.println("some code 2 ...");
		
		if(2 - 2 == 0) {
			
			throw new MyException();
		}
		
		if(1 - 1 == 0) {	// 무조건 던져

			throw new IOException();	// exception 객체 생성
			
		}
		
		System.out.println("some code 3 ...");
		System.out.println("some code 4 ...");
		
	}

}