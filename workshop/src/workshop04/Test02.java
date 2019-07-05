package workshop04;

public class Test02 {
	
	public static void main(String[] args) {
		
		int[] arr3=new int[5];
		int sum=0;
		
		for (int i=0;i<arr3.length;i++) {
			arr3[i]=(int)(Math.random()*10)+1;
			sum+=arr3[i];
		}
		for (int num:arr3) {
		System.out.print(num+" ");
		}
		System.out.println();
		System.out.println("sum="+sum);
		System.out.println("avg="+(double)sum/arr3.length);
	}
}
