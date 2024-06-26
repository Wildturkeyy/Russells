package day0426.ch24.ex1;

import java.util.ArrayList;
import java.util.List;

public class ExtendsTypeTest {
	
	public static void printPersonList(List<?> list){
		for (Object obj: list) {
			System.out.println(((Person)obj).getName());
		}
	}
	
	public static void printEmployeeList(List<? extends Employee> list) {
		for (Employee employee: list) {
			System.out.println(employee.getSalary());
		}
	}
	
	public static void printStudentList(List<? extends Student> list) {
		for (Student student: list) {
			System.out.println(student.getGrade());
		}
	}
	
	
	
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("홍길동"));
		personList.add(new Person("이길동"));
		personList.add(new Person("김길동"));
		
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("홍길동", 1000000));
		employeeList.add(new Employee("이길동", 2000000));
		employeeList.add(new Employee("김길동", 3000000));
		
		List<Student> studentLsit = new ArrayList<Student>();
		studentLsit.add(new Student("홍길동", 1));
		studentLsit.add(new Student("이길동", 2));
		studentLsit.add(new Student("김길동", 3));
		
		List<College> collegeList = new ArrayList<College>();
		collegeList.add(new College("홍길동", 1, 20));
		collegeList.add(new College("이길동", 2, 21));
		collegeList.add(new College("김길동", 3, 22));
		
		printPersonList(personList);
		System.out.println();
		printPersonList(employeeList);
		System.out.println();
		printPersonList(studentLsit);
		System.out.println();
		printPersonList(collegeList);
		System.out.println();
		System.out.println();
		
//		printEmployeeList(personList);
		printEmployeeList(employeeList);
//		printEmployeeList(studentList);
//		printEmployeeList(collegeList);
		System.out.println();
		System.out.println();
		
//		printStudentList(personList);
//		printStudentList(employeeList);
		printStudentList(studentLsit);
		printStudentList(collegeList);
		System.out.println();
	}
}
