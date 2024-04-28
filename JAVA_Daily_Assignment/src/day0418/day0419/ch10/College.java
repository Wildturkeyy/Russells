package day0419.ch10;

public class College extends Student{
	private int courses;
	
	public College(String name, int grade, String gender, int age, int courses) {
		super();
		super.name = name;
		super.age = age;
		super.gender = gender;
		super.grade = grade;
		this.courses = courses;
		
	}
	
	public int getCourse() {
		return courses;
	}
	
	@Override
	public String getStudInfo() {
		System.out.println("College 클래스의 getStudInfo() 메서드 입니다.");
		return "이름: " +name+ ", 학년: " +grade+ ", 성별: " +gender+ ", 나이" +age+ "학점: " +courses;
	}
}
