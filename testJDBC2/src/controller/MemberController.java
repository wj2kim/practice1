package controller;

import java.util.List;

import kh.member.dao.MemberDao;
import kh.member.vo.Member;
import view.MainView;

public class MemberController {
	
	public void mainView() {
		new MainView().mainMenu();
	}
	public void selectAll() {
		List<Member>list=new MemberDao().selectAll();
		new MainView().displayAll(list);
	}

}
