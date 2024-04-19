package day0417.ch07.ex4;

import java.util.Arrays;

public class ArrayParameterTest {

	public static void main(String[] args) {
		//매개변수가 배열인 메서드 
		int[] num = {10, 20, 30, 40, 50};
		String[] name = {"이순신", "홍길동", "임꺽정"};
		
		ArrayParameterTest m = new ArrayParameterTest();
		m.printArray(num);
		m.printString(name);
		
		System.out.println("종료");
	}
	
	public void printArray(int[] arr) {
		System.out.println("printArray() 메서드 호출");
		System.out.println(Arrays.toString(arr));
	}
	
	public void printString(String[] arr) {
		System.out.println("printString() 메서드 호출");
		System.out.println(Arrays.toString(arr));
	}

}
