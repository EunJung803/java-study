package prob5;

public class MyStackException extends Exception {
	
	public MyStackException(String message) {
		super(message);
	}
	
	public MyStackException() {
		super("stack is empty");
	}
}
