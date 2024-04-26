package chapter04;

import java.util.Objects;

public class Point {
	
	private int x;
	private int y;
	
	public Point() {
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);		// 자바에서 구현한 해싱알고리즘 (내용 기반으로 해싱), 두 내용이 같으면 같은 해싱값
										// 원래는 주소 기반이라 해시 코드가 다른데 내용 기반으로 바꿔버림
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public int getX() {
		return x;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	

}
