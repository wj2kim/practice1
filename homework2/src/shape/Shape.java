package shape;

public abstract class Shape {
	
	protected int width;
	protected int height;
	protected String colors;
	
	public Shape() {
	
	}

	public Shape(int width, int height, String colors) {
		super();
		this.width = width;
		this.height = height;
		this.colors = colors;
	}
	
	public double getArea() {
		return width*height;
	}

	public String getColors() {
		return colors;
	}
	
	
	
}
