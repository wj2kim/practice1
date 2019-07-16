package com.controller;

import java.util.List;

import com.member.service.MemberService;
import com.member.vo.Member;
import com.view.MainView;

import common.JDBCTemplate;

public class MemberController {
	private MemberService service=new MemberService();
	
	public void selectAll() {
		List<Member>list=service.selectAll();
		if(list.isEmpty()) {
			new MainView().printMsg("등록된 회원이 없습니다.");
		}else {
			new MainView().displayAllMember(list);
		}
	}
	
	public void selectId() {
		String id=new MainView().inputData("조회하고싶은 아이디");
		List<Member>list=service.selectId(id);
		if(list.isEmpty()) {
			new MainView().printMsg("찾으시는 회원이 없습니다.");
		}else {
			new MainView().displayAllMember(list);
		}
	}
	
	public void selectName() {
		String name=new MainView().inputData("조회하고 싶은 이름");
		List<Member>list=service.selectName(name);
		if(list.isEmpty()) {
			new MainView().printMsg("찾으시는 회원이 없거나 이름이 잘못되었습니다.");
		}else {
			new MainView().displayAllMember(list);
		}
	}
	
	public void insertMember() {
		Member m=new MainView().getMemberInfo();
		String msg=service.insertMember(m);
		new MainView().printMsg(msg);
	}
	
	public void updateMember() {
		String id=new MainView().inputData("수정할 아이디: ");
		Member m=new MainView().updateData();
		String msg = service.updateData(m,id);
		new MainView().printMsg(msg);
	}
}
