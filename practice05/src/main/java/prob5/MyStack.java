package prob5;

public class MyStack {

	private int len;
	private int top;
	private String[] stack;
	
	public MyStack(int len) {
		this.len = len;
		this.top = -1;
		this.stack = new String[len];
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public String[] getStack() {
		return stack;
	}

	public void setStack(String[] stack) {
		this.stack = stack;
	}

	public void push(String string) {
		if(top >= len-1) {
			setStack(resize());
		}
		setTop(top+1);
		stack[top] = string;
	}

	public String pop() throws MyStackException {
		int tmpTop = getTop();
		if(tmpTop < 0) {
			throw new MyStackException();
		}
		setTop(top-1);
		return stack[tmpTop];
	}

	public boolean isEmpty() {
		if(top >= 0) {
			return false;
		}
		return true;
	}
	
	public String[] resize() {
		String[] tmp = new String[len * 2];
		for(int i=0; i<len; i++) {
			tmp[i] = stack[i];
		}
		setLen(len * 2);
		return tmp;
	}
	
}