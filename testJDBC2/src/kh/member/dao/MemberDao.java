package kh.member.dao;

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
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}

}
