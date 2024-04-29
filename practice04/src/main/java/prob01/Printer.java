package prob01;

public class Printer {
	
//	public void println(int i) {
//		System.out.println(i);
//	}
//
//	public void println(boolean b) {
//		System.out.println(b);
//	}
//
//	public void println(double d) {
//		System.out.println(d);
//	}
//
//	public void println(String string) {
//		System.out.println(string);
//	}
	
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	// 제너릭 오버로드
	public <T> void println(T...ts) {
		for(T tt : ts) {
			System.out.println(tt);
		}
	}

	// 가변파라미터
	public int sum(Integer... nums) {
		int s = 0;
		for(Integer n : nums) {
			s += n;
		}
		
		return s;
	}
	
	

}
