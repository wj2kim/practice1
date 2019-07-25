package controller;

import memberDto.Member;
import memberService.MemberService;
import view.MainView;

public class MemberController {
	
	public void memberJoin() {
		Member m=new MainView().getMemberInfo();
		String msg=new MemberService().memberJoin(m);
		new MainView().printMsg(msg);
	}

}
