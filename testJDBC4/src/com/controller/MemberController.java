package com.controller;

import java.util.List;

import com.member.dao.MemberDao;
import com.member.vo.Member;
import com.view.MainView;

public class MemberController {
	
	public void displayAll() {
		List<Member>list=new MemberDao().displayAllMember();
		new MainView().displayMember(list);
	}
	
	public void displayById() {
		String id=new MainView().inputData("조회하고싶은 아이디");
		List<Member>list=new MemberDao().displayMemberById(id);
		new MainView().displayMember(list);
	}
	
	public void displayByName() {
		String name=new MainView().inputData("조회하고싶은 이름");
		List<Member>list=new MemberDao().displayMemberByName(name);
		new MainView().displayMember(list);
	}
	
	public void insertMember() {
		Member m=new MainView().insertData();
		int result=new MemberDao().insertMember(m);
		String msg=result>0?"회원등록성공":"회원등록실패";
		new MainView().printMsg(msg);
	}
	
	public void updateMember() {
		String id=new MainView().inputData("수정할 아이디");
		Member m=new MainView().updateData();
		m.setMemberId(id);
		int result=new MemberDao().updateMember(m);
		String msg=result>0?"회원수정 완료!":"회원수정 실패";
		new MainView().printMsg(msg);
	}
	
	public void deleteMember() {
		String id=new MainView().inputData("삭제할 아이디");
		int result=new MemberDao().deleteData(id);
		String msg=result>0?"회원삭제성공":"회원삭제실패";
		new MainView().printMsg(msg);
		
	}
	
	

}
