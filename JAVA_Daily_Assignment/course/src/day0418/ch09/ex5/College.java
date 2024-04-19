package day0418.ch09.ex5;

public class College extends Student{
	private int courses; //학점
	//일반적으로 자식 클래스 필드는 private
	
	public College() {
		this("이순신", 2, 20);
	}
	
	public College(String name, int grade, int courses) {
		super(); // 명시적으로 적어줌
		System.out.println("College 생성자 호출");
		super.name = name;
		super.grade = grade;
		this.courses = courses;
	}
	
	public int getCourses() {
		return courses;
	}
	
	@Override
	public String getStuInfo() {
		System.out.println("College 클래스의 getStuInfo 메서드입니다.");
		return "이름: " +name+ ", 학년: " +grade+ ", 신청학점: " +courses;
	}
}
