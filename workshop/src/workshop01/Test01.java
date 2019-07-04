package workshop01;

import java.util.Scanner;

public class Test01 {

	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		System.out.println("(1~10의 수를 하나씩 두번 입력하시오");
		int boon=sc.nextInt();
		int mo=sc.nextInt();
		
		if ((double)boon%(double)mo>1) {
			System.out.println("나머지가 1 보다 크다!");
		}
		else if ((double)boon%(double)mo<=1) {
			System.out.println("나머지가 1보다 작거나 같다!");
		}
	}
}
