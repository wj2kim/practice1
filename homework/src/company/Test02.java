package company;

import java.util.Scanner;

public class Test02 {
	
	static Scanner sc=new Scanner(System.in);
;	
	public static void main(String[] args) {
		
		System.out.println("월 기본급 입력: ");
		
		Company co=new Company(sc.nextDouble());
		
		System.out.println("연 기본급 합: "+co.getAnnualIncome()+" 세후: "+co.getAfterTaxIncome());
		System.out.println("연 보너스 합: "+co.getBonus()*4+" 세후: "+co.getAfterTaxBonus()*4);
		System.out.println("연 지급액 합: "+(co.getAfterTaxIncome()+(co.getAfterTaxBonus()*4)));
	}
}
