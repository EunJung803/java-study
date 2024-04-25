package paint;

public class Main {

	public static void main(String[] args) {
		
		Point point = new Point(10, 20);
		
//		Point point = new Point();
//		point.setX(10);
//		point.setY(20);
		
		drawPoint(point);
		
//		point.disappear();
		point.show(true);
		point.show(false);
		
		ColorPoint point2 = new ColorPoint(100, 200, "red");
		drawColorPoint(point2);

	}

	private static void drawPoint(Point point) {
		point.show();
	}
	
	private static void drawColorPoint(ColorPoint point) {
		point.show();
	}
	
}
