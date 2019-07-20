package com.view;

import java.util.List;
import java.util.Scanner;

import com.controller.MemberController;
import com.member.vo.Member;

public class MainView {
	Scanner sc=new Scanner(System.in);
	private MemberController controller=new MemberController();
	
	public void mainMenu() {
		int key=0;
		while((key=menu())!=0){
			switch(key) {
			case 1:
				controller.displayAll();
				break;
			case 2:
				controller.displayById();
				break;
			case 3:
				controller.displayByName();
				break;
			case 4:
				controller.insertMember();
				break;
			case 5:
				controller.updateMember();
				break;
			case 6:
				controller.deleteMember();
				break;
			}
		}
	}
	
	public int menu() {
		System.out.println("==== 회원관리프로그램 Practice =====");
		return getNumInput("[1] 전체회원조회\n[2] 아이디로 회원조회\n[3] 이름으로 회원조회\n[4] 회원등록\n[5] 회원수정\n[6] 회원탈퇴\n[0] 프로그램 종료");
	}
	
	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	public int getNumInput(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}
	
	public String inputData(String type) {
		System.out.println("==== "+type+" ====");
		System.out.println("입력: ");
		return sc.nextLine();
	}
	
	public Member insertData() {
		System.out.println("==== 회원정보 등록 ====");
		System.out.print("아이디: ");
		String id=sc.nextLine();
		System.out.print("비밀번호: ");
		String pw=sc.nextLine();
		System.out.print("이름: ");
		String name=sc.nextLine();
		System.out.print("성별(M/F): ");
		String gender=sc.nextLine();
		System.out.print("나이: ");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.println("이메일: ");
		String email=sc.nextLine();
		System.out.print("전화번호: ");
		String phone=sc.nextLine();
		System.out.println("주소: ");
		String address=sc.nextLine();
		System.out.println("취미(,로 구분)");
		String hobby=sc.nextLine();
		
		return new Member(id,pw,name,gender.charAt(0),age,email,address,phone,hobby,null);
	}
	
	public Member updateData() {
		Member m=new Member();
		System.out.println("==== 회원정보 수정 ====");
		System.out.println("나이: ");
		int age=sc.nextInt();
		System.out.println("이메일: ");
		String email=sc.nextLine();
		System.out.println("전화번호: ");
		String phone=sc.nextLine();
		return m;
	}
	
	public void displayMember(List<Member>list) {
		for(Member m:list) {
			System.out.println("==== "+m.getMemberId()+"님의 회원 정보 ====");
			System.out.println(m);
		}
	}

	
}
