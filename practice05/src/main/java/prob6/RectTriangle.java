package prob6;

public class RectTriangle extends Shape implements Resizable {
	
	public RectTriangle(double width, double height) {
		super(width, height);
	}
	
	@Override
	public double getArea() {
		return width * height / 2;
	}
	
	@Override
	public double getPerimeter() {
		return width + height + Math.sqrt(width*width + height*height);
	}
	
	@Override
	public void resize(double d) {
		width = width * d;
		height = height * d;
	}
}
