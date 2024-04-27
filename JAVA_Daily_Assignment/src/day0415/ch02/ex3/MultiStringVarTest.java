package day0415.ch02.ex3;

public class MultiStringVarTest {

	public static void main(String[] args) {
		
		// 문자열 변수를 동시에 선언하기
		String name, address, major; // 문자열 변수 동시 선언
		
		name = "홍길동";
		address = "서울시 강동구";
		major = "컴퓨터 공학과";
		
		System.out.println("이름: " + name
					   + ", 주소: " + address
					   + ", 전공: " + major);
	}

}
