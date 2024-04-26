package prob03;

public abstract class Unit {
	
	// 현재 위치
	private int x;
	private int y;

	public void setVaule(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/* 지정된 위치로 이동 */
	abstract void move(int x, int y);
	
	/* 현재 위치에 정지 */
	abstract void stop();

	
}
