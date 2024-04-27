package day0418.ch09.ex4;

public class StudentTest {

	public static void main(String[] args) {
		String sinsang = null;
		College c1 = new College("홍길동", 3, 22);
		College c2 = new College();
		
		System.out.println();
		sinsang = c1.getStuInfo();
		System.out.println("학생정보");
		System.out.println("------------------------");
		System.out.println(sinsang+ ", 수강 학점: " +c1.getCourses()+ "점");
		
		System.out.println();
		sinsang = c2.getStuInfo();
		System.out.println("학생정보");
		System.out.println("------------------------");
		System.out.println(sinsang+ ", 수강 학점: " +c2.getCourses()+ "점");
		
		
		
	}

}
