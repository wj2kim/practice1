package account;


import java.util.ArrayList;

public class AccountTest2 {

	static ArrayList <Account>list= new ArrayList<Account>();
	
	public static void main(String[] args) {
		
		// for 문을 이용하여 account객체를 배열에 생성
		for(int i=1;i<=5;i++) {
			list.add(new Account("221-0101-211"+i,100000,0.045));
			list.get(i-1).accountInfo();
			System.out.println();
		}
		
		System.out.println();
		for (int i=0;i<5;i++) { 
			list.get(i).setInterestRate(0.037); // for 문 이용 이자율 3.7% 넣어주기 
			list.get(i).accountInfo();
			System.out.print(" "+(int)(list.get(i).getBalance()*list.get(i).getInterestRate())+"원");
			System.out.println();
		}
		
	}
		

	
	
	
	

}
