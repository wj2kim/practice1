package month;

public class Months {
	
	int day=31;
	int day2=30;
	int day3=28;
	
	public int getDays(int months) {
		
		switch(months) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			return day;
		case 9: case 4: case 6: case 11:
			return day2;
		case 2:
			return day3;
		}
		return 0;
	}

}
