package prob2;

public class SmartPhone extends MusicPhone {
	
//	@Override
//	public void execute(String function) {
//		if("음악".equals(function)) {
//			playMusic();
//		}
//		else if("앱".equals(function)) {
//			app();
//		}
//		else {
//			super.execute(function);
//		}
//	}
	
	@Override
	public void execute(String function) {
		if ("앱".equals(function)) {
			app();
			return;
		}
		super.execute(function);
	}
	
	@Override
	protected void playMusic() {
		System.out.println("다운로드해서 음악재생");
	}
	
	protected void app() {
		System.out.println("앱실행");
	}
}
