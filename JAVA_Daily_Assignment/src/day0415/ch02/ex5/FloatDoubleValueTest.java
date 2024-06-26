package day0415.ch02.ex5;

public class FloatDoubleValueTest {

	public static void main(String[] args) {

		// 여러 가지 자바 실수 표현법
		
		// float double 형의 최소, 최대값
		System.out.println("float 최대값 : " + Float.MAX_VALUE);
		System.out.println("float 최소값 : " + Float.MIN_VALUE);
		System.out.println("double 최소값 : " + Double.MIN_VALUE);
		System.out.println("double 최대값 : " + Double.MAX_VALUE);
		System.out.println();
		
		//float와 double형 실수 표현법
		System.out.println(1.23456F);
		System.out.println(1.23456d);
		System.out.println(1.23456);
		System.out.println();
		
		System.out.println(123.0);
		System.out.println(123.);
		System.out.println(.28);
		System.out.println();
		
		//지수 표현법
		System.out.println(2e+10);
		System.out.println(9.26E3);
		System.out.println(0.67e-7);
		System.out.println();
		
		//정밀도
		System.out.println(3.141592653589793238464338327F); // float 타입의 실수 유효 자릿수는 7자리
		System.out.println(3.141592653589793238464338327d); // double 타입의 실수 유효 자릿수는 16자리
	}

}
