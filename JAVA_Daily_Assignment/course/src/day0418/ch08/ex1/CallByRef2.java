package day0418.ch08.ex1;

public class CallByRef2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallByRef2 ref = new CallByRef2();
		Student2 s1 = new Student2("이순신", 3);
		
		System.out.println("메서드 호출 전");
		System.out.println("이름: "+s1.name);
		System.out.println("학년: "+s1.grade);
		
		System.out.println("\n메서드 호출 후");
		ref.setStuInfo(s1);
		System.out.println("이름: "+s1.name);
		System.out.println("학년: "+s1.grade);
	}
	
	public void setStuInfo(Student2 s) {
		s.name = "홍길동";
		s.grade = 2;
	}

}

class Student2{
	String name;
	int grade;
	
	public Student2(String _name, int _grade) {
		name = _name;
		grade = _grade;
	}
}