package month;

import java.util.Scanner;

public class MonthsTest {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Months mo=new Months();
		
		while(true) {
			System.out.println("1~12까지 정수형태로 입력하시오");
			int months=sc.nextInt();
				
				if(months>12) {
					System.out.println("입력된 값이 잘못 되었습니다.");
				}
				else if(months<=12) {
					System.out.println("입력받은월: "+ months+"월");
					System.out.println("마지막일자: "+mo.getDays(months)+"일");
				}break;
		}
	}
}
