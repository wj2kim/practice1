package com.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.member.vo.Member;

public class MemberDao {
	
	public Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			conn.setAutoCommit(false);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public int insertMember(Member m) {
		Connection conn=this.getConnection();
		Statement stmt=null;
		PreparedStatement pstmt=null;
		int result=0;
		String sql="insert into member values(?,?,?,?,?,?,?,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, String.valueOf(m.getGender()));
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6,m.getEmail());
			pstmt.setString(7,m.getPhone());
			pstmt.setString(8,m.getAddress());
			pstmt.setString(9,m.getHobby());

			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
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
		PreparedStatement pstmt=null;
		int result=0;
		String sql="update member set age=?,email=?,phone=? where member_id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, m.getAge());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(5, m.getMemberId());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				if(result>0) conn.commit();
				else conn.rollback();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;	
	}
	
	public List<Member> displayMemberById(String id) {
		List<Member>list=new ArrayList<Member>();
		Connection conn=this.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			stmt=conn.createStatement();
			String sql="select * from member where member_id='"+id+"'";
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
				m.setHobby(rs.getString("hobby"));
				m.setEnrollDate(rs.getDate("enroll_date"));
				list.add(m);
			}
		}catch(SQLException e) {
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
	
	public List<Member>displayMemberByName(String name){
	List<Member>list=new ArrayList<Member>();
	Connection conn=this.getConnection();
	Statement stmt=null;
	ResultSet rs=null;
	try {
		stmt=conn.createStatement();
		String sql="select * from member where member_name like '%"+name+"%'";
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
			m.setHobby(rs.getString("hobby"));
			m.setEnrollDate(rs.getDate("enroll_date"));
			list.add(m);
		}
	}catch(SQLException e) {
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
	
	public List displayAllMember() {
		List<Member>list=new ArrayList<Member>();
		Connection conn=this.getConnection();
		Statement stmt=null;
		ResultSet rs= null;
		try {
			stmt=conn.createStatement();
			String sql="select * from member";
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
				m.setHobby(rs.getString("hobby"));
				m.setEnrollDate(rs.getDate("enroll_date"));
				list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
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
	
	public int deleteData(String id) {
		Connection conn=this.getConnection();
		PreparedStatement pstmt=null;
		int result=0;
		String sql="delete from member where member_id='"+id+"'";
		
		try {
			pstmt=conn.prepareStatement(sql);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				if(result>0) conn.commit();
				else conn.rollback();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
