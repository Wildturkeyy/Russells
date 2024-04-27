package day0425.ch17.ex3;

import java.util.Objects;

public class Student {

	// hashCode()와 equals() 메서드를 오버라이딩한 클래스
	String hakbun;
	String name;
	int grade;
	
	Student(){
		this("20220001", "이순신", 3);
	}

	public Student(String hakbun, String name, int grade) {
		this.hakbun = hakbun;
		this.name = name;
		this.grade = grade;
	}
	
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "[학번: " + hakbun + ", 이름: " + name + ", 학년: " + grade + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(hakbun+name+grade);
	}

	@Override
//	public boolean equals(Object obj) {
//		String _hakbun = ((Student)obj).hakbun;
//		int _grade = ((Student)obj).grade;
//		
//		if (hakbun.equals(_hakbun) && (grade == _grade)) {
//			return true;
//		}else {
//			return false;
//		}
//	}
	public boolean equals(Object obj) {
		if (obj instanceof Student s) {
			return this.hakbun == s.hakbun && this.name == s.name && this.grade == s.grade;
		}else {
			return false;
		}
	}

}
