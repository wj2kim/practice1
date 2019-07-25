package view;

import java.util.Scanner;

import controller.MemberController;
import memberDto.Member;

public class MainView {
	Scanner sc=new Scanner(System.in);
	MemberController mcon=new MemberController();
	
	public void mainMenu() {
		int key=0;
		while((key=menu())!=0){
			switch(key) {
			case 1:
				mcon.memberJoin();
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
		System.out.println("회원관리창");
		return getIntInput("[1]회원가입\n[2]회원조회\n[3]회원수정\n[4]회원삭제\n[0]종료");
	}
	
	public int getIntInput(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}
	
	public Member getMemberInfo() {
		Member m=new Member();
		System.out.println("===== 회원정보입력 =====");
		System.out.println("아이디 입력: ");
		System.out.println("===== 회원가입 ======");
		System.out.println("아이디: ");
		m.setMemberId(sc.nextLine());
		System.out.println("비밀번호: ");
		m.setMemberPwd(sc.nextLine());
		System.out.println("이름: ");
		m.setMemberName(sc.nextLine());
		System.out.println("이메일: ");
		m.setEmail(sc.nextLine());
		System.out.println("주소: ");
		m.setAddress(sc.nextLine());
		System.out.println("전화번호: ");
		m.setPhone(sc.nextLine());
		return m;
	}
	
	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
}
