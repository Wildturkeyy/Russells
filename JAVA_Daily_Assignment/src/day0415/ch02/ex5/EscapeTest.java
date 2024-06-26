package day0415.ch02.ex5;

public class EscapeTest {

	public static void main(String[] args) {

		// 이스케이프 문자 사용하기
		/*
		 * - \t : 탭
		 * - \n : 개행 문자
		 * - \r : 열 복귀 (다음 줄 맨 앞으로 이동)
		 * - \" : 이중 인용 부호(')
		 * - \' : 단일 인용 부호(")
		 * - \\ : 백슬래시(\)
		 * - \ u16 진수 : 16진수 유니코드에 해당하는 문자 출력
		 */
		String str1 = "Hello World!";
		String str2 = "Hello \nWorld!";
		String str3 = "Hello \tWorld!";
		String str4 = "Hello \rWorld!";
		String str5 = "\'Hello World!\'";
		String str6 = "\"Hello World!\"";
		String str7 = "\\Hello World!\\";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		System.out.println(str5);
		System.out.println(str6);
		System.out.println(str7);
	}

}
