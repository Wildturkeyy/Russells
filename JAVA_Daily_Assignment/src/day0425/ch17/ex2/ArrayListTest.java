package day0425.ch17.ex2;

import java.util.ArrayList;
import java.util.List;

import day0419.ch10.Student;

public class ArrayListTest {
	public static void main(String[] args) {
		List aList = new ArrayList();
		
		//객체 저장하기
		aList.add("홍길동");
		aList.add(178);
		aList.add(new Student());
		
		//객체 얻기
//		String name = aList.get(0); // 에러 발생
		String name = (String)aList.get(0);
		int num1 = (int)aList.get(1);
		Integer num2 = (Integer)aList.get(1);
		Student student = (Student)aList.get(2);
		
		System.out.println("name " + name);
		System.out.println("num " + num1 + " " + num2.intValue());
		System.out.println("stu " + student);
		
		//객체 수정
		aList.set(0, "hello");
		aList.set(1, new Float(3.14));
//		aList.set(2, College);
		System.out.println(aList.toString());
		
		//객체 삭제
		aList.remove(1);
		System.out.println(aList.toString());
	}
}
