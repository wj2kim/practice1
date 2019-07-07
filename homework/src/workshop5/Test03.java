package workshop5;

public class Test03 {
	
	public static void main(String[] args) {
		
		int [] [] arr2= {
						{20,30,10},
						{50,40,60},
						{80,80,90}
		};
		
		for(int i=arr2.length;i-->0;) {
			for(int j=arr2[i].length;j-->0;) {
				System.out.print(arr2[i][j]+" ");				
			}
		}
		
		
	}

}
