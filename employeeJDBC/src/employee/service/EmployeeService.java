package employee.service;

import java.sql.Connection;
import java.util.List;

import Common.JDBCTemplate;
import employee.dao.EmployeeDao;
import employee.dto.Employee;

public class EmployeeService {
	private EmployeeDao dao=new EmployeeDao();
	
	public List<Employee> displayAllInfo(){
		Connection conn=JDBCTemplate.getConnection();
		List<Employee>list=dao.displayAllInfo(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public List<Employee> displaySelectedInfo(String id, String name, String deptCode, int salary){
		Connection conn=JDBCTemplate.getConnection();
		List<Employee>list=dao.displaySingleInfo(conn,id,name,deptCode,salary);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public String insertEmployeeData(Employee e) {
		Connection conn=JDBCTemplate.getConnection();
		int result=dao.insertEmployee(conn,e);
		String msg="";
		if (result>0) {
			JDBCTemplate.commit(conn);
			msg="회원등록'성공'";
		}else {
			JDBCTemplate.rollback(conn);
			msg="회원등록'실패'";
		}
		JDBCTemplate.close(conn);
		return msg;
	}

}
