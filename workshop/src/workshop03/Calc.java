package workshop03;

public class Calc {

	int sum=0;
	
	public int calculate(int data){
		
		for(int i=0;i<data;i++) {
			if(i%2==0) {
				sum+=i;
			}
		} return sum;
	}
	
}
