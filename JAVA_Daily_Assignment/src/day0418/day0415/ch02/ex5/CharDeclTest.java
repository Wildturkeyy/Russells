package day0415.ch02.ex5;

public class CharDeclTest {

	public static void main(String[] args) {

		// 문자 타입 변수 선언 후 값 출력하기
		char ch1 = 'a';
		char ch2 = '가';
//		char ch3 = 'ab'; //문자형 변수에는 한 개의 문자만 저장
//		char ch4 = "a"; // 문자형 변수에 문자열을 대입하면 에러가 발생
		
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println();
		
		System.out.println(ch1 + "의 유니코드 = " + (int)ch1);
		System.out.println(ch2 + "의 유니코드 = " + (int)ch2);
	}

}
