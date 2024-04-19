package day0418.ch09.ex5;

public class Student {
	//일반적으로 상위 클래스 필드는 protected 접근자를 사용함.
	protected String name;
	protected int grade;
	
	//생성자
	public Student() {
		System.out.println("Student 기본 생성자 호출");
	}
	
	public Student(String name, int grade) {
		System.out.println("매개변수가 있는 Student 생성자 호출");
		this.name = name;
		this.grade = grade;
	}
	
	public void study() {
		System.out.println("시험 공부를 합니다.");
	}
	
	public int test() {
		System.out.println("시험 점수입니다.");
		return 0;
	}
	
	//학생 신상 정보 출력 메서드
	public String getStuInfo() {
		return "이름: " +name+ ", 학년: " +grade;
	}
}
