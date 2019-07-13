package kh.view;

import java.util.List;
import java.util.Scanner;

import controller.MemberController;
import kh.member.vo.Member;

public class MainView {
	Scanner sc=new Scanner(System.in);
	
	public void mainMenu() {
		int key=0;
		while((key=menu())!=0) {
			switch(key) {
			case 1:
				MemberController.selectAll();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			}
		}
	}
	
	public int menu() {
		System.out.println("==== 회원관리 프로그램 ====");
		return getNumInput("[1]전체회원 조회\n"+"[2]회원조회 ID\n");
	}
	
	public int getNumInput(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}
	
	public void displayAll(List<Member>list) {
		System.out.println("모든 멤버 조회결과");
		for(Member m:list) {
			System.out.println("아이디: "+m.getMemberId()+"\t"+"이름: "+m.getMemberName());
		}
		
	}
}
