package workshop5;

import java.util.Scanner;

public class Test01 {
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("문자 입력: ");
		String msg=sc.nextLine();
		
		char [] letter=msg.toCharArray();
		
		for(int i=letter.length;i-->0;) {
			System.out.print(letter[i]);
		}
		
		
//		String [] letter=msg.split("");
		

	}

}
