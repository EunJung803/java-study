package thread;

public class AlphabetThread extends Thread {

	@Override
	public void run() {
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
