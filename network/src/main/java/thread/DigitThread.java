package thread;

public class DigitThread extends Thread {

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.print(i);
			
			try {
				Thread.sleep(1000);		// 하나 출력하고 잠들면 -> 다른 스레드 실행됨 -> 다시 돌아와서 하나 출력 ...
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
