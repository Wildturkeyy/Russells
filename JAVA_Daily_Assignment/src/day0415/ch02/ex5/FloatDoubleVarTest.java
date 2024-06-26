package day0415.ch02.ex5;

public class FloatDoubleVarTest {

	public static void main(String[] args) {

		// 자바 실수 변수 사용하기
		float num1 = 1.23456F;
		double num2 = 1.23456d;
		double num3 = 1.23456;
		
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		System.out.println("num3 = " + num3);
		
//		num1 = .28; //자바의 실수는 double이 기본 타입이므로 float타입 변수에 할당하면 에러가 발생함
//		num2 = .28F; // 자동으로 double 타입 실수 0.28d로 변환되어서 변수에 저장됨.
		
		// 변수에 지수형 실수 대입하기
		num1 = .28F;
		num2 = 2e+10;
		num3 = 9.26E3;
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		System.out.println("num3 = " + num3);
		
		
	}

}
