package mobile;

public class Ltab extends Mobile{
	
	private String mobileName;
	private int batterySize;
	private String osType;
	
	public Ltab() {
	
	}
	
	
	
	
	public Ltab(String mobileName, int batterySize, String osType) {
		super(mobileName,batterySize,osType);
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}


	@Override
	public int operate(int time) {
		batterySize-=(time*10);
		return batterySize;
	}
	@Override
	public int charge(int time) {
		batterySize+=(time*10);
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
