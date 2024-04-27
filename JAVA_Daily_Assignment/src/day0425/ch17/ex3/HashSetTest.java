package day0425.ch17.ex3;

import java.util.Set;
import day0425.ch17.ex3.Student;

public class HashSetTest {

	public static void main(String[] args) {
		Set set = new java.util.HashSet<>();
		
		Student s1 = new Student("20220002", "홍길동", 2);
		System.out.println(s1.hashCode());
		set.add(new Student());
		set.add(s1);
		
		set.add("hello");
		set.add(Integer.valueOf(178));
		set.add(Float.valueOf(4.56F));
		set.add("hello");
		set.add(Integer.valueOf(178));
		Student s2 = new Student("20220002", "홍길동", 2);
		set.add(s2);
		
		Object[] obj = set.toArray();
		for (int i=0; i<obj.length; i++) {
			System.out.println(obj[i]);
		}
		System.out.println(set);
	}

}
