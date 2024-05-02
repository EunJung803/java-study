package thread;

public class ThreadEx01 {
	
	public static void main(String[] args) {
		// 메인 스레드 말고 다른 스레드로 실행되도록 할 것임
//		for(int i=0; i<10; i++) {
//			System.out.print(i);
//		}
		
		new DigitThread().start(); 		// 스레드 객체 생성 -> 실행시켜줌
		
		for(char c='a'; c<='j'; c++) {
			System.out.print(c);
			
			try {
				Thread.sleep(1000);		// 하나 출력하고 잠들면 -> 다른 스레드 실행됨 -> 다시 돌아와서 하나 출력 ...
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
