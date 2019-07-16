package com.view;

import java.util.List;
import java.util.Scanner;

import com.controller.MemberController;
import com.member.dao.MemberDao;
import com.member.vo.Member;

public class MainView {
	Scanner sc=new Scanner(System.in);
	private MemberController controller=new MemberController();
	
	public void mainMenu() {
		int key=0;
		while((key=menu())!=0) {
			switch(key){
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
		System.out.println("==== 회원관리 프로그램 ===");
		return getNumInt("[1]회원 전체 조회\n[2]회원조회 ID\n[3]이름으로 조회\n[4]회원가입\n[5]회원수정\n[0]프로그램 종료");
	}

	public int getNumInt(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}
	public String getStrInput(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	
	public void displayAll(List<Member>list) {
		System.out.println("모든 회원 조회 결과");
		for(Member m:list) {
			System.out.println("아이디: "+m.getMemberId()+"\n이름: "+m.getMemberName()+"\n이메일: "+m.getEmail());
			System.out.println(); 
		}
	}
	
	public String inputData(String type) {
		Scanner sc=new Scanner(System.in);
		System.out.println("==== "+type+" 입력 ====");
		System.out.println("입력: ");
		return sc.next();
	}
	
	public void printMsg(String msg) {
		System.out.println("==== 시스템 메시지 ====");
		System.out.println(msg);
		System.out.println("====================");
	}
	
	public void displaySingleMember(Member m) {
		System.out.println("==== 회원조회결과 ====");
		System.out.println(m);
		System.out.println("====================");
	}
	
	public void displaySingleMemberByName(List<Member>list) {
		System.out.println("==== 회원조회결과 ====");
		for(Member m:list) {
			System.out.println(m);
		}
		System.out.println("====================");
	}
	
	public Member memberJoin() {
		Scanner sc=new Scanner(System.in);
		Member m=new Member();
		System.out.println("==== 회원가입 ====");
		System.out.println("아이디: ");
		m.setMemberId(sc.nextLine());
		System.out.println("비밀번호");
		m.setMemberPwd(sc.nextLine());
		System.out.println("이름");
		m.setMemberName(sc.nextLine());
		System.out.println("성별(M/F): ");
		m.setGender(sc.nextLine().charAt(0));
		System.out.println("나이: ");
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.println("전화번호: ");
		m.setPhone(sc.nextLine());
		System.out.println("이메일: ");
		m.setEmail(sc.nextLine());
		System.out.println("주소: ");
		m.setAddress(sc.nextLine());
		System.out.println("취미(,로 구분): ");
		m.setHobby(sc.nextLine());
		
		return m;
		}
	
	public Member updateData() {
		Scanner sc=new Scanner(System.in);
		Member m=new Member();
		System.out.println("==== 회원정보 수정 ====");
		System.out.println("나이: ");
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.println("이메일: ");
		m.setEmail(sc.nextLine());
		System.out.println("주소: ");
		m.setAddress(sc.nextLine());
		System.out.println("전화번호: ");
		m.setPhone(sc.nextLine());
		return m;
	}
}
