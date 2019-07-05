package account;

public class Account {
	
	private String account;
	private int balance;
	private double interestRate;
	
	public Account() {
	
	}

	public Account(String account, int balance, double interestRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getBalance() {
		return balance;
	}

	public double calculateInterest() {
		return balance*interestRate;
	} 
	
	public void deposit(int money) {
		balance=balance+money;
	}
	
	public void withdraw (int money) {
		balance=balance-money;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	

	@Override
	public String toString() {
		return "Account [account=" + account + ", balance=" + balance + ", interestRate=" + interestRate + "]";
	}
	
	
	public void accountInfo() { 	// for 문을 이용하여 Account 정보 출력 
			System.out.printf("계좌번호: %s 잔액: %d원 이자율: %.1f%%",account,balance,interestRate*100);
	}

	
	
	
	
	

}
