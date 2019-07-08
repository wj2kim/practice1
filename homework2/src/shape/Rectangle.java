package shape;

public class Rectangle extends Shape{
	
	
	public Rectangle() {
	
	}
	
	
	
	public Rectangle(int width, int height, String color) {
		super(width,height,color);
	}

	
	

	public double getArea() {
		return (width*height);
	}
	
	public void setResize(int size) {
		width+=size;
	}



}
