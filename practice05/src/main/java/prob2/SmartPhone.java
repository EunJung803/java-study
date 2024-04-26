package prob2;

public class SmartPhone extends MusicPhone {
	
	@Override
	public void execute(String function) {
		if("음악".equals(function)) {
			music();
		}
		else if("앱".equals(function)) {
			app();
		}
		else {
			super.execute(function);
		}
	}
	
	private void music() {
		System.out.println("다운로드해서 음악재생");
	}
	
	private void app() {
		System.out.println("앱실행");
	}
}
