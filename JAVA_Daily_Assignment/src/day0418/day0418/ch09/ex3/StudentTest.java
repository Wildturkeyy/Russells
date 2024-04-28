package day0418.ch09.ex3;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sinsang = null;
		Middle m = new Middle("이순신", 2);
		College c = new College("홍길동", 3, 20);
		
		sinsang = m.getStuInfo();
		System.out.println("학생정보");
		System.out.println("---------------------");
		System.out.println(sinsang);
		
		sinsang = c.getStuInfo();
		System.out.println("학생정보");
		System.out.println("---------------------");
		System.out.println(sinsang+ ", 수강 학점: " +c.getCourses()+ "점");
		
	}

}
