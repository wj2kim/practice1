package workshop02;

import java.util.Arrays;

public class Test01 {
	
	public static void main(String[] args) {
		
		
			int max=0;
			int min=100;
			
			for (int i=0;i<args.length;i++) {
				if (max<(int) Integer.parseInt(args[i])) {
					max=(int) Integer.parseInt(args[i]);
				}
				if (min>(int) Integer.parseInt(args[i])) {
					min=(int) Integer.parseInt(args[i]);
				}
			}
			System.out.println("최대값: "+max);
			System.out.println("최소값: "+min);
		
			
			
			
			
				
	}

}
