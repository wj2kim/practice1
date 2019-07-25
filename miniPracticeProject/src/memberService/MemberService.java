package memberService;

import java.sql.Connection;

import common.JDBCTemplate;
import memberDao.MemberDao;
import memberDto.Member;

public class MemberService {
	
	public String memberJoin(Member m) {
		Connection conn=new JDBCTemplate().getConnection();
		int result=new MemberDao().memberJoin(conn,m);
		String msg="";
		if(result>0) {
			JDBCTemplate.commit(conn);
			msg="회원가입 완료";
		}else {
			JDBCTemplate.rollback(conn);
			msg="회원가입 실패";
		}
		JDBCTemplate.close(conn);
		return msg;
	}
}
