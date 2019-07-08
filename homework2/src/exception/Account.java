package exception;

public class Account {
	
	private String account;
	private double balance;
	private double interestRate;
	
	public Account() {
		
	}

	public Account(String account, double balance, double interestRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	
	
	public String getAccount() {
		return account;
	}

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public double calculateInterest(double balance) {
		return balance*0.073;
	}
	
	public void deposit(double money) throws Exception {
		if (money<0||money>balance){
			throw new Exception();
		}
		else 
			balance=+money;
	}
	
	public void withdraw(double money) throws Exception {
		if(money<0) {
			throw new Exception();
		}
		else
			balance=-money;
	}
}
