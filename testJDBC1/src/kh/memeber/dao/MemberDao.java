package kh.memeber.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.member.vo.Member;

public class MemberDao {
	
	public List selectAll() {
		
		List<Member>list=new ArrayList<Member>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
		conn.setAutoCommit(false);
		stmt=conn.createStatement();
		String sql="SELECT * FROM MEMBER";
		rs=stmt.executeQuery(sql);
		
		while(rs.next()) {
			Member m=new Member();
			m.setMemberId(rs.getString("member_id"));
			m.setMemberPwd(rs.getString("member_pwd"));
			m.setMemberName(rs.getString("member_name"));
			m.setGender(rs.getString("gender").charAt(0));
			m.setAge(rs.getInt("age"));
			m.setEmail(rs.getString("email"));
			m.setPhone(rs.getString("phone"));
			m.setAddress(rs.getString("address"));
			m.setEnrollDate(rs.getDate("enroll_date"));
			
			list.add(m);
		}
		
		int result=stmt.executeUpdate(sql);
		if (result>0) {
			conn.commit();
			System.out.println("회원가입 완료");
		}
		else {
			conn.rollback();
			System.out.println("회원가입 실패");
		}
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
