package shape;

public class Triangle extends Shape{
	
	public Triangle() {
	
	}
	
	
	public Triangle(int width, int height, String color) {
		super(width, height, color);
	}

	
	

	public double getArea() {
		return (width*height)/2;
	}
	
	public void setResize(int size) {
		height+=size;
	}

}
