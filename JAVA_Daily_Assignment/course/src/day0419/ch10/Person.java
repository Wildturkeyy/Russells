package day0419.ch10;

public class Person {
	protected String gender;
	protected int age;
	
	public Person() {
		System.out.println("Person클래스 기본 생성자 호출");
	}
	
	public String getGender() {
		return gender;
	}
	
	public int getAge() {
		return age;
	}
}
