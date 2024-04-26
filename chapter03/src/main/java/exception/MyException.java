package exception;

@SuppressWarnings("serial")		//serial에 대한 warning 없애는 어노테이션
public class MyException extends Exception {
	
	// 커스텀 메세지 사용하기
	public MyException(String message) {
		super(message);
	}
	
	// default 메세지 사용하기
	public MyException() {
		super("MyException Thrown");
	}
	
}
