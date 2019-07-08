package mobile;

public abstract class Mobile {
	
	private String mobileName;
	private int batterySize;
	private String osType;
	
	public Mobile() {
	
	}
	
	
	public Mobile(String mobileName, int batterySize, String osType) {
		super();
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}
	




	public abstract int operate(int time);
	
	public abstract int charge(int time);
	
	
}
