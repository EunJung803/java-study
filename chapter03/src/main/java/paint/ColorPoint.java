package paint;

public class ColorPoint extends Point {
	private String color;
	
	public ColorPoint(int x, int y, String color) {
//		setX(x);
//		setY(y);
		super(x, y); 		// 부모에 만들어져있는 생성자로 불러내기 -> 부모에 기본 생성자를 오버로딩 할 필요 X
		this.color = color;	
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
