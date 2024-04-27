package day0425.ch17.ex3;

import java.util.ArrayList;
import java.util.List;

public class ArrayListGenericTest {

	public static void main(String[] args) {
		List<String> aList1 = new ArrayList<String>();
//		aList1.add(Integer.valueOf(100); //String 타입으로 제네릭을 지정했으므로 ArrayList에는 문자열만 저장할 수 있다.
		aList1.add("이순신");
		aList1.add("홍길동");
		aList1.add("손흥민");
		aList1.add("차범근");
		
		String name1 = aList1.get(0); //다운캐스팅 없이 문자열을 받을 수 있음
//		String name2 = (String)aList1.get(0);
//		String name2 = (Integer)aList1.get(0); //다른 타입으로 다운캐스팅 시 컴파일 단계에서 에러 발생
		
		for (int i=0; i<aList1.size(); i++) {
			String name2 = aList1.get(i);
			System.out.println(name2);
		}
		
		
		//
		List<Student> aList2 = new ArrayList<Student>();
		aList2.add(new Student("이순신", 3));
		aList2.add(new Student("홍길동", 2));
		aList2.add(new Student("손흥민", 1));
		
//		aList2.add(Integer.valueOf(100));//다른 타입 저장시 에러 발생
		
		Student s1 = aList2.get(0);
		System.out.println();
		
		for (int i=0; i<aList2.size(); i++) {
			Student s2 = aList2.get(i);
			System.out.println(s2.toString());
		}
		
		
		
		
	}

}
