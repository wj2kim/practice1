package account;

import java.util.Scanner;

public class AccountTest {
	
	Scanner sc=new Scanner (System.in);

	public static void main(String[] args) {
		
		Account account= new Account("441-0290-1203",500000,0.073);
		
		System.out.println("계좌정보: "+account.getAccount()+" "+"현재잔액: "+account.getBalance());
		account.deposit(20000);
		System.out.println("계좌정보: "+account.getAccount()+" "+"현재잔액: "+account.getBalance());
		System.out.println("이자: "+account.calculateInterest());
		
	}
}
		
		
		
		
		
		
		
		
//		int key=0;
//		
//		while((key==menu())=0) {
//			switch(key) {
//			case 1: 
//				
//				break;
//			case 2:
//				
//				break;
//			case 3:
//				
//				break;
//			case 4:
//				
//				break;
//			}
//		}
//	}
//	
//	public int menu() {
//		System.out.println("WELCOME TO WOOBANK");
//		return getIntInput("[1]create account [2]display account [3]deposit [0]exit");
//	}
//	
//	public int getIntInput(String msg) {
//		System.out.println(msg);
//		return sc.nextInt();
//	}

		

