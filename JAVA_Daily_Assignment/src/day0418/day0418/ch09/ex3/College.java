package day0418.ch09.ex3;

public class College extends Student{
	private int courses; //학점
	//일반적으로 자식 클래스 필드는 private
	
	public College(String _name, int _grade, int _courses) {
		System.out.println("College 생성자 호출");
		name = _name;
		grade = _grade;
		courses = _courses;
	}
	
	public int getCourses() {
		return courses;
	}
}
