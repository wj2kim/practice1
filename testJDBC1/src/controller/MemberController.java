package controller;

import java.util.List;

import kh.member.vo.Member;
import kh.memeber.dao.MemberDao;
import kh.view.MainView;

public class MemberController {
	
	public void mainView() {
		new MainView().mainMenu();
	}
	
	public static void selectAll() {
		
		List<Member>list=new MemberDao().selectAll();
		new MainView().displayAll(list);
	}

}
