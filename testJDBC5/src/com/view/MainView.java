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
		while((key=menu())!=0) {
			switch(key) {
			case 1:
				controller.selectAll();
				break;
			case 2:
				controller.selectId();
				break;
			case 3:
				controller.selectName();
				break;
			case 4:
				controller.insertMember();
				break;
			case 5:
				controller.updateMember();
				break;
			}
		}
	}
	
	public int menu() {
		System.out.println(" ***** 회원관리프로그램 ver2 *****");
		return getNumInput("[1] 전체회원조회\n[2] 아이디로 회원조회\n[3] 이름으로 회원조회\n[4] 회원등록\n[5] 회원수정\n[0] 프로그램 종료");
	}
	
	public int getNumInput(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}
	
	public void displayAllMember(List<Member>list) {
		for (Member m:list) {
			System.out.println("[ 반값습니다! "+m.getMemberId()+"님! ]");
			System.out.println(m);
			System.out.println();
		}
	}
	
	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	public String inputData(String type) {
		System.out.println("==== "+type+"====");
		System.out.println("입력: ");
		return sc.nextLine();
	}
	
	public Member getMemberInfo() {
		Member m=new Member();
		System.out.println(" ===== 회원가입을 환영합니다 =====");
		System.out.print("아이디: ");
		m.setMemberId(sc.nextLine());
		System.out.print("비밀번호: ");
		m.setMemberPwd(sc.nextLine());
		System.out.print("이름: ");
		m.setMemberName(sc.nextLine());
		System.out.print("성별(M/F): ");
		m.setGender(sc.next().charAt(0));
		System.out.print("나이: ");
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.println("이메일: ");
		m.setEmail(sc.nextLine());
		System.out.println("전화번호: ");
		m.setPhone(sc.nextLine());
		System.out.println("주소: ");
		m.setAddress(sc.nextLine());
		System.out.println("취미(,로 구분)");
		m.setHobby(sc.nextLine());
		return m;
	}
	
	public Member updateData() {
		Member m=new Member();
		System.out.println("===== 회원정보 수정 =====");
		System.out.println("비밀번호: ");
		m.setMemberPwd(sc.nextLine());
		System.out.println("이메일: ");
		m.setEmail(sc.nextLine());
		System.out.println("전화번호");
		m.setPhone(sc.nextLine());
		System.out.println("취미 (,로 구분): ");
		m.setHobby(sc.nextLine());
		return m;
	}
}
