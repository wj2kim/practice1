package company;

import java.util.Scanner;

public class Test02 {
	
	static Scanner sc=new Scanner(System.in);
;	
	public static void main(String[] args) {
		
		System.out.println("�� �⺻�� �Է�: ");
		
		Company co=new Company(sc.nextDouble());
		
		System.out.println("�� �⺻�� ��: "+co.getAnnualIncome()+" ����: "+co.getAfterTaxIncome());
		System.out.println("�� ���ʽ� ��: "+co.getBonus()*4+" ����: "+co.getAfterTaxBonus()*4);
		System.out.println("�� ���޾� ��: "+(co.getAfterTaxIncome()+(co.getAfterTaxBonus()*4)));
	}
}
