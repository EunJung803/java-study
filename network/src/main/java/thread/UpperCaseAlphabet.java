package thread;

// A ~ J 까지 화면에 출력하는 일반 클래스
public class UpperCaseAlphabet {
	
	public void print() {
		for(char c = 'A'; c <= 'J'; c++) {
			System.out.print(c);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
