package memberDao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import common.JDBCTemplate;
import memberDto.Member;

public class MemberDao {
		private Properties prop=new Properties();
		
		public MemberDao() {
			try {
				prop.load(new FileReader("member.properties"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public int memberJoin(Connection conn, Member m) {
			PreparedStatement pstmt=null;
			int result=0;
			String sql="insert into member values (seq_member.nextval,?,?,?,?,?,?,sysdate)";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, m.getMemberId());
				pstmt.setString(2, m.getMemberPwd());
				pstmt.setString(3, m.getMemberName());
				pstmt.setString(4, m.getEmail());
				pstmt.setString(5, m.getAddress());
				pstmt.setString(6, m.getPhone());
				result=pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}
	

}
