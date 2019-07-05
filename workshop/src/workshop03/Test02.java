package workshop03;

import java.util.Scanner;

public class Test02 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Calc cc= new Calc();
		
		
		while(true) {
		System.out.println("5~10까지의 정수형 데이터 하나 입력:");
		int data=sc.nextInt();
		
			if (data>10) {
				System.out.println("다시 입력하세요");
			}
			else if (data<=10) {
				System.out.println(cc.calculate(data));
			} break;
		}
	}
}
