package day0415.ch02.ex5;

public class CharConversionTest {

	public static void main(String[] args) {

		// 소문자를 대문자로 바꾸기
		char ch1 = 'h';
		char ch2 = 'e';
		char ch3 = 'l';
		char ch4 = 'l';
		char ch5 = 'o';
		
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		System.out.println(ch5);
		System.out.println();
		
		System.out.println(ch1 -32);
		System.out.println(ch2 -32);
		System.out.println(ch3 -32);
		System.out.println(ch4 -32);
		System.out.println(ch5 -32);
		System.out.println();
		
		System.out.println((char)(ch1 -32));
		System.out.println((char)(ch2 -32));
		System.out.println((char)(ch3 -32));
		System.out.println((char)(ch4 -32));
		System.out.println((char)(ch5 -32));
		
	}

}
