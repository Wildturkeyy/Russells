package day0416.ch04.ex3;

public class SingOpTest {

	public static void main(String[] args) {

		// 부호 연산자 사용하기
		int num1 = -100;
		double num2 = +3.1415;
		
		System.out.println(+num1);
		System.out.println(+num2);
		
		System.out.println(-num1);
		System.out.println(-num2);
		
		System.out.println(num1);
		System.out.println(num2);
		
		num1 = -num1;
		num2 = -num2;
		
		System.out.println(num1);
		System.out.println(num2);
		
	}

}
