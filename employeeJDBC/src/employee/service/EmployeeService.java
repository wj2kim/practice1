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
		Employee em=new Employee();
		em.setEmpId(id); em.setEmpName(name); em.setDeptCode(deptCode); em.setSalary(salary);
		List<Employee>list=dao.displaySingleInfo(conn,em);
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
	
	public String updateEmployee(Employee e) {
		Connection conn=JDBCTemplate.getConnection();
		int result=dao.updateEmployee(conn,e);
		String msg="";
		if (result>0) {
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
