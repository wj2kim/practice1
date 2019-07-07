package exception;

public class AccountTest {
	
	public static void main(String[] args) {
	
		Account account=new Account("441-0290-1203",500000,0.073);
		
		System.out.println(account.getAccount()+" "+(int)(account.getBalance())+" "+account.getInterestRate());
		
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("처리할 수 없습니다! 다시 입금해 주세요.");
			e.printStackTrace();
		}
		
	}
	
}
