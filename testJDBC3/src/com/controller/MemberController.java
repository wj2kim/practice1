package com.controller;

import java.util.List;

import com.member.dao.MemberDao;
import com.member.vo.Member;
import com.view.MainView;

public class MemberController {
	private MemberDao dao=new MemberDao();
	
	public void selectAll() {
		List<Member>list=new MemberDao().selectAll();
		new MainView().displayAll(list);
	}
	//ID로 조회하는 메소드 생성하기
	public void selectId() {
		String id=new MainView().inputData("아이디");
		Member m=new MemberDao().selectId(id);
	// View 결과값이 없을 수도 있으니 
		if(m==null) {
			new MainView().printMsg("조회한 회원이 없습니다.");
		}
		else {
			new MainView().displaySingleMember(m);
		}	
	}
	//Name 으로 조회하는 메소드 생성하기
	public void selectName() {
		String name=new MainView().inputData("이름");
		List<Member>list =new MemberDao().selectName(name);
		if(!(list.size()>0)) {
			new MainView().printMsg("조회한 회원이 없습니다.");
		}
		else {
			new MainView().displaySingleMemberByName(list);
		}
	}
	
//	회원 수정하는 메소드 생성하기
//	public void selectEditMember() {
//		int age=new MainView().getNumInt("수정할 나이 입력: ");
//		Member m=new MemberDao().updateMember(age);
//	// View 결과값이 없을 수도 있으니 
//	}
		// 삽입 메소드 생성하기 
	public void insertMember() {
		// client 한테 회원가입에 필요한 데이터를 받는 창을 출력 !
		Member m=new MainView().memberJoin();
		int result=new MemberDao().insertMember(m);
		String msg="";
		msg=result>0?"회원가입이 완료 되었습니다.":"회원가입을 실패하였습니다.";
		new MainView().printMsg(msg);
	}
	
	//	 회원수정 메소드
	public void updateMember() {
		// 나이, 이메일, 주소, 전화번호, 수정할 회원의 PK(아이디)
		String id=new MainView().inputData("수정할 아이디");
		
		Member m=new MainView().updateData();
		m.setMemberId(id);
		int result=dao.updateMember(m);
		String msg=result>0?"회원수정 완료!":"회원수정 실패";
		new MainView().printMsg(msg);
	}
}
