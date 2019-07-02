package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import member.vo.Member;

public class MemberJoinDAO {
	
	Scanner sc= new Scanner (System.in);
	ArrayList<Member> list=new ArrayList<Member>();
	static MemberJoinDAO mjd= new MemberJoinDAO();
	
	
	public MemberJoinDAO() {

	}

	public void run() {
		int key=0;
		while ((key=menu())!=0){
			switch(key) {
			case 1:
				login();
				break;
			case 2:
//				register();
				break;
			case 3:
				displayMember();
				break;
			case 4:
//				searchMember();
				break;
			}
		}
	}
	
	public int menu() {
		System.out.println("Welcome");
		return getIntInput ("[1]Log In [2]Join [3]Search [0]Exit");
	}
	
	public void displayMember() {
		Iterator<Member> ite=list.iterator();
		if(ite.hasNext()) {
			System.out.println(ite.next());
		}
	}
	
	public void login() {
		sc.nextLine();
		String id=getStrInput("ID: ");
		String pw=getStrInput("pw: ");
		
		for (Member m : list) {
			if(m.getId().equals(id)&&m.getPw().equals(pw)){
				System.out.println("Welcome User "+ m.getId());
			}
			else if (!(m.getId().equals(id))) {
				System.out.println("Check your ID");
			}
			else {
				System.out.println("Your Password is Incorrect");
			}
		}	
	}
	
	public void register() {
		sc.nextLine();
		String id=getStrInput("ID: ");
		String pw=getStrInput("Password: ");
		String pw2=getStrInput("Confirm Password: ");
		String name=getStrInput("Name: ");
		String phone=getStrInput("Phone: ");
		
		if (idcheck(id)) {
			System.out.println("Cannot Use this ID");
		}
		else if (pw.equals(pw2)) {
			System.out.println("Thank you for the register!");
			list.add(new Member(id,pw,name,phone));
		}
		else
			System.out.println("Your Password is Incorrect");
	}
	
	public boolean idcheck(String id) {
		boolean check = true;
		for (Member m: list) {
			if (m.getId().contentEquals(id)) {
				return check;
			}
		}
		return false;
	}
	
	public int getIntInput(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}
	
	public String getStrInput(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	
	
	
	
	
}
