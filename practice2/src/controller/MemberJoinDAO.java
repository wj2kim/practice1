package controller;

import java.util.ArrayList;
import java.util.Scanner;

import member.vo.Member;

public class MemberJoinDAO {
	
	Scanner sc= new Scanner (System.in);
	ArrayList<Member> list=new ArrayList<Member>();
	
	public MemberJoinDAO() {

	}

	public void run() {
		int key=0;
		while ((key=menu())!=0){
			switch(key) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			}
		}
	}
	
	public int menu() {
		System.out.println("Welcome");
		return getIntInput ("[1]Log In [2]Join [3]Search [0]Exit");
	}
	
	public int getIntInput(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}
	
	
	
	
	
}
