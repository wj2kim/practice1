package mobile;

public class Otab extends Mobile{
	
	private String mobileName;
	private int batterySize;
	private String osType;
	
	public Otab() {
	
	}
	
	
	
	
	public Otab(String mobileName, int batterySize, String osType) {
		super(mobileName,batterySize,osType);
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}


	@Override
	public int operate(int time) {
		batterySize-=(time*12);
		return batterySize;
	}
	@Override
	public int charge(int time) {
		batterySize+=(time*8);
		return batterySize;
	}




	public String getMobileName() {
		return mobileName;
	}




	public int getBatterySize() {
		return batterySize;
	}




	public String getOsType() {
		return osType;
	}
}
