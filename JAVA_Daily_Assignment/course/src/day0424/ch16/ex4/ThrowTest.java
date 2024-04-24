package day0424.ch16.ex4;

import java.io.IOException;

public class ThrowTest {
	
	public static void call() throws IOException{
		System.out.println("call 메서드 시작");
		
		int[] num = new int[2];
		common.test(num);
		
		if (num.length == 2) {
			throw new IOException("배열 크기가 2");
		}
		System.out.println("call() 메서드 종료");
	}
	
	//
	public static void main(String[] args) {
		try {
			call();
		}catch (IOException e) {
			String message = e.getMessage();
			System.out.println(message);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
	}
}
