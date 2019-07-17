package employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Common.JDBCTemplate;
import employee.dto.Employee;

public class EmployeeDao {
	
	public List<Employee> displayAllInfo(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Employee>list=new ArrayList();
		String sql="select * from employee";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Employee e=new Employee();
				e.setEmpId(rs.getString("emp_id"));
				e.setEmpName(rs.getString("emp_name"));
				e.setEmpNo(rs.getString("emp_no"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getString("phone"));
				e.setDeptCode(rs.getString("dept_code"));
				e.setJobCode(rs.getString("job_code"));
				e.setSalLevel(rs.getString("sal_level"));
				e.setSalary(rs.getInt("salary"));
				e.setBonus(rs.getDouble("bonus"));
				e.setManagerId(rs.getInt("manager_id"));
				e.setHireDate(rs.getDate("hire_date"));
				e.setEntDate(rs.getDate("ent_date"));
				e.setEntYN(rs.getString("ent_yn").charAt(0));
				list.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public List<Employee> displaySingleInfo(Connection conn, String id, String name, String deptCode, int salary){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Employee>list=new ArrayList();
		
		if((id!=null)&&name==null) {
		String sql="select * from employee where emp_id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
		
			while(rs.next()) {
				Employee e=new Employee();
				e.setEmpId(rs.getString("emp_id"));
				e.setEmpName(rs.getString("emp_name"));
				e.setEmpNo(rs.getString("emp_no"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getString("phone"));
				e.setDeptCode(rs.getString("dept_code"));
				e.setJobCode(rs.getString("job_code"));
				e.setSalLevel(rs.getString("sal_level"));
				e.setSalary(rs.getInt("salary"));
				e.setBonus(rs.getDouble("bonus"));
				e.setManagerId(rs.getInt("manager_id"));
				e.setHireDate(rs.getDate("hire_date"));
				e.setEntDate(rs.getDate("ent_date"));
				e.setEntYN(rs.getString("ent_yn").charAt(0));
				list.add(e);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
	}
		
		else if((name!=null)&&id==null) {
			String sql="select * from employee where emp_name like ?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, "%"+name+"%");
				rs=pstmt.executeQuery();
			
				while(rs.next()) {
					Employee e=new Employee();
					e.setEmpId(rs.getString("emp_id"));
					e.setEmpName(rs.getString("emp_name"));
					e.setEmpNo(rs.getString("emp_no"));
					e.setEmail(rs.getString("email"));
					e.setPhone(rs.getString("phone"));
					e.setDeptCode(rs.getString("dept_code"));
					e.setJobCode(rs.getString("job_code"));
					e.setSalLevel(rs.getString("sal_level"));
					e.setSalary(rs.getInt("salary"));
					e.setBonus(rs.getDouble("bonus"));
					e.setManagerId(rs.getInt("manager_id"));
					e.setHireDate(rs.getDate("hire_date"));
					e.setEntDate(rs.getDate("ent_date"));
					e.setEntYN(rs.getString("ent_yn").charAt(0));
					list.add(e);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(pstmt);
			}
		}
		
		else if (name==null&&(deptCode!=null)) {
			String sql="select * from employee where dept_code=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, deptCode);
				rs=pstmt.executeQuery();
			
				while(rs.next()) {
					Employee e=new Employee();
					e.setEmpId(rs.getString("emp_id"));
					e.setEmpName(rs.getString("emp_name"));
					e.setEmpNo(rs.getString("emp_no"));
					e.setEmail(rs.getString("email"));
					e.setPhone(rs.getString("phone"));
					e.setDeptCode(rs.getString("dept_code"));
					e.setJobCode(rs.getString("job_code"));
					e.setSalLevel(rs.getString("sal_level"));
					e.setSalary(rs.getInt("salary"));
					e.setBonus(rs.getDouble("bonus"));
					e.setManagerId(rs.getInt("manager_id"));
					e.setHireDate(rs.getDate("hire_date"));
					e.setEntDate(rs.getDate("ent_date"));
					e.setEntYN(rs.getString("ent_yn").charAt(0));
					list.add(e);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(pstmt);
			}
		}
		
		else if (name==null&&deptCode==null&&salary>0) {
			salary=salary/12;
			String sql="select * from employee where salary>?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, salary);
				rs=pstmt.executeQuery();
			
				while(rs.next()) {
					Employee e=new Employee();
					e.setEmpId(rs.getString("emp_id"));
					e.setEmpName(rs.getString("emp_name"));
					e.setEmpNo(rs.getString("emp_no"));
					e.setEmail(rs.getString("email"));
					e.setPhone(rs.getString("phone"));
					e.setDeptCode(rs.getString("dept_code"));
					e.setJobCode(rs.getString("job_code"));
					e.setSalLevel(rs.getString("sal_level"));
					e.setSalary(rs.getInt("salary"));
					e.setBonus(rs.getDouble("bonus"));
					e.setManagerId(rs.getInt("manager_id"));
					e.setHireDate(rs.getDate("hire_date"));
					e.setEntDate(rs.getDate("ent_date"));
					e.setEntYN(rs.getString("ent_yn").charAt(0));
					list.add(e);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(pstmt);
			}
		}
		return list;
	}	
	
	public int insertEmployee(Connection conn, Employee e) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="insert into employee values(?,?,?,?,?,?,?,?,?,?,?,sysdate,null,'N')";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, e.getEmpId());
			pstmt.setString(2, e.getEmpName());
			pstmt.setString(3, e.getEmpNo());
			pstmt.setString(4, e.getEmail());
			pstmt.setString(5, e.getPhone());
			pstmt.setString(6, e.getDeptCode());
			pstmt.setString(7, e.getJobCode());
			pstmt.setString(8, e.getSalLevel());
			pstmt.setInt(9, e.getSalary());
			pstmt.setDouble(10, e.getBonus());
			pstmt.setInt(11, e.getManagerId());
			result=pstmt.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
