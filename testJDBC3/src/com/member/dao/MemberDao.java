package com.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.member.vo.Member;

public class MemberDao {
	
	public List selectAll() {
		List<Member>list=new ArrayList<Member>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
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
		
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return list;
	}
	
	// 아이디 조회 메소드 만들기
	public Member selectId(String id) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="SELECT*FROM MEMBER WHERE MEMBER_ID='"+id+"'";
		Member m=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				m=new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender").charAt(0));
				m.setAge(rs.getInt("age"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setAddress((rs.getString("address")));
				m.setHobby(rs.getString("hobby"));
				m.setEnrollDate(rs.getDate("enroll_date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
	// 이름으로 조회
	public List<Member> selectName(String name) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		Member m;
		String sql="SELECT * FROM MEMBER WHERE MEMBER_NAME like '%"+name+"%'";
		List<Member>list=new ArrayList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				m=new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender").charAt(0));
				m.setAge(rs.getInt("age"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setAddress((rs.getString("address")));
				m.setHobby(rs.getString("hobby"));
				m.setEnrollDate(rs.getDate("enroll_date"));
				list.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int insertMember(Member m) {
		Connection conn=null;
		Statement stmt=null;
		int result=0;
		String sql="INSERT INTO MEMBER VALUES("+"'"+m.getMemberId()+"',"
													+"'"+m.getMemberPwd()+"',"
													+"'"+m.getMemberName()+"',"
													+"'"+m.getGender()+"',"
													+m.getAge()+","
													+"'"+m.getEmail()+"',"
													+"'"+m.getPhone()+"',"
													+"'"+m.getAddress()+"',"
													+"'"+m.getHobby()+"',"
													+"sysdate)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			conn.setAutoCommit(false);
			stmt=conn.createStatement();
			result=stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				if(result>0) conn.commit();
				else conn.rollback();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateMember(Member m) {
		Connection conn=this.getConnection();
		Statement stmt=null;
		int result=0;
		String sql="UPDATE MEMBER SET AGE="+m.getAge()+", "+"email='"+m.getEmail()+"', "
															+"address='"+m.getAddress()+"', "
															+"phone='"+m.getPhone()+"', "
															+" WHERE MEMBER_ID='"+m.getMemberId()+"'";
		try {
			stmt=conn.createStatement();
			result=stmt.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				if(result>0) conn.commit();
				else conn.rollback();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 커넥션 메소드
	public Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			conn.setAutoCommit(false);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
