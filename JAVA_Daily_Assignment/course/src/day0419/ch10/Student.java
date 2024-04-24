package day0419.ch10;

public class Student extends Person{
	protected String name;
	protected int grade;
	
	public Student() {
		System.out.println("Student 생성자 호출");
	}
	
	public String getStudInfo() {
		System.out.println("Student 클래스의 getSudtInfo 메서드 호출");
		return "이름: " +name+ ", 학년: " +grade+ ", 성별: " +gender+ ", 나이" +age;
	}
}
