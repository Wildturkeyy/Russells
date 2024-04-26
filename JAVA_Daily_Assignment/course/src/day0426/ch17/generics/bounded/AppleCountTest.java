package day0426.ch17.generics.bounded;

public class AppleCountTest {

	public static void main(String[] args) {
		Apple a1 = new Apple(10);
		Apple[] apples = {new Apple(20), new Apple(9), new Apple(11), new Apple(6), new Apple(30)};
		
		var count = Counter.countGreaterThan(apples, a1);
		System.out.println("a1 사과보다 무거운 사과 개수 :" +count);
		
		Student s1 = new Student(50);
		var students = new Student[] {new Student(11), new Student(98), new Student(55), new Student(78)};
		count = Counter.countGreaterThan(students, s1);
		System.out.println("s1 학생보다 점수가 높은 학생 수: " + count);
		
	}

}
