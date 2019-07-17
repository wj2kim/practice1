package employee.controller;

import java.lang.reflect.Member;
import java.util.List;

import employee.dto.Employee;
import employee.service.EmployeeService;
import employee.view.MainView;

public class EmployeeController {
	private EmployeeService service=new EmployeeService();
	
	public void displayAllMember() {
		List<Employee>list=service.displayAllInfo();
		if(list.isEmpty()) {
			new MainView().printMsg("등록된 직원이 없습니다.");
		}else {
			new MainView().displayEmployee(list);
		}
	}
	
	public void displayMemberById() {
		String id=new MainView().inputData("아이디");
		List<Employee>list=service.displaySelectedInfo(id, null, null,0);
		if(list.isEmpty()) {
			new MainView().printMsg("해당 아이디는 없습니다.");
		}else {
			new MainView().displayEmployee(list);
		}
	}
	
	public void displayMemberByName() {
		String name=new MainView().inputData("이름");
		List<Employee>list=service.displaySelectedInfo(null,name,null,0);
		if(list.isEmpty()) {
			new MainView().printMsg("찾는 이름이 없습니다.");
		}else {
			new MainView().displayEmployee(list);
		}
	}
	
	public void displayMemberByDept() {
		String deptCode=new MainView().inputData("부서코드");
		List<Employee>list=service.displaySelectedInfo(null, null,deptCode, 0);
		if(list.isEmpty()) {
			new MainView().printMsg("찾는 이름이 없습니다.");
		}else {
			new MainView().displayEmployee(list);
		}
	}
	
	public void displayMemberBySalary() {
		int salary=new MainView().inputNumber("연봉 입력");
		List<Employee>list=service.displaySelectedInfo(null, null, null, salary);
		if(list.isEmpty()) {
			new MainView().printMsg("찾는 사원이 없습니다.");
		}else {
			new MainView().displayEmployee(list);
		}	
	}
	
	public void insertEmployee() {
		Employee e=new MainView().getEmployeeInfo();
		String msg=service.insertEmployeeData(e);
		new MainView().printMsg(msg);
	}
}
