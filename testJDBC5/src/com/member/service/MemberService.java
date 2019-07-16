package com.member.service;

import java.sql.Connection;
import java.util.List;

import com.member.dao.MemberDao;
import com.member.vo.Member;

import common.JDBCTemplate;

public class MemberService {
	
	private MemberDao dao=new MemberDao();
	
	public List<Member> selectAll(){
		Connection conn= JDBCTemplate.getConnection();
		List<Member>list=dao.selectAll(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public List<Member> selectId(String id){
		Connection conn= JDBCTemplate.getConnection();
		List<Member>list=dao.selectById(conn,id);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public List<Member>selectName(String name){
		Connection conn=JDBCTemplate.getConnection();
		List<Member>list=dao.selectByName(conn, name);
		JDBCTemplate.close(conn);
		return list;
	}
	public String insertMember(Member m) {
		Connection conn=JDBCTemplate.getConnection();
		int result=dao.insertMember(conn,m);
		String msg="";
		if(result>0) {
			JDBCTemplate.commit(conn);
			msg="회원등록'성공'";
		}else {
			JDBCTemplate.rollback(conn);
			msg="회원등록'실패'";
		}
		JDBCTemplate.close(conn);
		return msg;
	}
	
	public String updateData(Member m, String id) {
		Connection conn=JDBCTemplate.getConnection();
		int result=dao.updateMember(conn, m, id);
		String msg="";
		if(result>0) {
			JDBCTemplate.commit(conn);
			msg="회원수정'성공'";
		}else {
			JDBCTemplate.rollback(conn);
			msg="회원수정'실패'";
		}
		JDBCTemplate.close(conn);
		return msg;
	}
}
