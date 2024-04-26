package prob6;

public abstract class Shape {
	
	protected double width;
	protected double height;

	public Shape(double width, double height) {
		this.width = width;
		this.height = height;
	}

	protected abstract double getArea();

	protected abstract double getPerimeter();

}
