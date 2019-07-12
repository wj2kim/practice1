package practiceException1;

public class A {
	
	private int [] arr=new int[3];
	A() {
		arr[0]=0;
		arr[1]=10;
		arr[2]=20;
	}
	public void z(int first, int second) {
		try {
		System.out.println(arr[first]/arr[second]);
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndexOutOfBoundsException 에러가 났습니다.");
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException 에러가 났습니다."); 
		}catch (Exception e) {
			 System.out.println("Exception 에러가 났습니다.");
		 }finally {
			 System.out.println("finally");
		 }
	}

}
