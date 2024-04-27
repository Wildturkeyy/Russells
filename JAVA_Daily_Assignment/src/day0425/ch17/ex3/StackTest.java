package day0425.ch17.ex3;

import java.util.Stack;

import day0419.ch10.Student;

public class StackTest {
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("홍길동");
		stack.push("이순신");
		stack.push(111);
		stack.push(new Student());
		
		Student s1 = (Student)stack.peek();
		System.out.println(s1);
		
		System.out.println(stack.toString());
		
		System.out.println();
		
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		
		System.out.println(stack.toString()); //모든 객체를 인출했으므로 stack은 비어있음
	}
}
