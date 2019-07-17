package employee.view;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Scanner;

import employee.controller.EmployeeController;
import employee.dto.Employee;

public class MainView {
	Scanner sc=new Scanner (System.in) ;
	EmployeeController controller= new EmployeeController();
			
	public void mainMenu() {
		int key=0;
		while((key=menu())!=0) {
			switch(key) {
			case 1:
				controller.displayAllMember();
				break;
			case 2:
				while((key=displayMenu())!=0) {
				switch(key) {
				case 1:
					controller.displayMemberById();
					break;
				case 2:
					controller.displayMemberByName();
					break;
				case 3:
					controller.displayMemberByDept();
					break;
				case 4:
					controller.displayMemberBySalary();
					break;
					}
				}
			case 3:
				controller.insertEmployee();
				break;
			case 4:
				controller.updateEmployee();
				break;
			}
		}
	}
	public int menu() {
		System.out.println("===== KH 사원 관리 ver.1 =====");
		return getIntInput("[1]전체사원조회 \n[2]사원 개별 조회 \n[3]사원등록 \n[4]사원수정 \n[5]사원삭제 \n[6]부서관리 \n[7]직책관리 \n[0]프로그램 종료");
	}
	
	public int displayMenu() {
		System.out.println("===== 상세 메뉴 =====");
		return getIntInput("[1]아이디로 검색 \n[2]이름으로 검색 \n[3]부서코드로 검색 \n[4]연봉으로 검색 \n[0]뒤로 돌아가기");
	}
	
	public int getIntInput(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}
	
	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	public String inputData(String type) {
		System.out.println("==== "+type+" ====");
		System.out.println("입력: ");
		return sc.nextLine();
	}
	public int inputNumber(String type) {
		System.out.println("==== "+type+" ====");
		System.out.println("입력: ");
		return sc.nextInt();
	}
	
	public void displayEmployee(List<Employee>list) {
		for(Employee e:list) {
			System.out.println("==== "+e.getEmpName()+"님의 정보 조회 ====");	
			System.out.println(e);
			System.out.println();
		}
	}
	
	public Employee getEmployeeInfo() {
		Employee e=new Employee();
		System.out.println("===== 사원 등록 =====");
		 System.out.print("아이디 입력: ");
	      e.setEmpId(sc.nextLine());
	      System.out.print("이름 입력: ");
	      e.setEmpName(sc.nextLine());
	      System.out.print("주민등록번호 입력: ");
	      e.setEmpNo(sc.nextLine());
	      System.out.print("이메일 입력: ");
	      e.setEmail(sc.nextLine());
	      System.out.print("전화번호 입력: ");
	      e.setPhone(sc.nextLine());
	      System.out.print("부서코드 입력: ");
	      e.setDeptCode(sc.nextLine());
	      System.out.print("직책 입력: ");
	      e.setJobCode(sc.nextLine());
	      System.out.print("급여등급 입력: ");
	      e.setSalLevel(sc.nextLine());
	      System.out.print("월급 입력: ");
	      e.setSalary(sc.nextInt());
	      System.out.print("보너스 입력: ");
	      e.setBonus(sc.nextDouble());
	      sc.nextLine();
	      System.out.print("매니저아이디 입력: ");
	      e.setManagerId(sc.nextInt());
	      return e;
	}
}
