package day0419.ch10;

public class Middle extends Student{
	
	public Middle(String name, int grade, String gender, int age) {
		super();
		System.out.println("매개변수가 4개인 Middel 클래스 생성자 호출");
		super.gender = gender;
		super.age = age;
		super.name = name;
		super.grade = grade;
	}
}
