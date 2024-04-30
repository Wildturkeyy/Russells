package sec04.p1211;

public class Student {
	private String name;
	private int grade;
	public static String msg;
	
	Student() {}
	
	Student(String name) {
		this.name = name;
	}
	
	public static void setStudent(String name, int grade) {
		msg = name + grade;
		System.out.println("학생: " + msg);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void hello(String greeting) {
		System.out.println(name + "이(가) 인사합니다." + greeting);
	}
}
