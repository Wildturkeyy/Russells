package day0415.ch04.ex2;

public class ArithmeticOpTest {

	public static void main(String[] args) {
		// 산술 연산자 사용하기
		int result = 0;
		int var1 = 5, var2 = 4;
		
		result = 100 + 200;
		System.out.println("result : " + result);
		
		result = var1 + 200;
		System.out.println("result : " + result);
		
		result = var1 + var2;
		System.out.println("result : " + result);
		
		result = result + var1;
		System.out.println("result : " + result);
		
		result = var1 - var2;
		System.out.println("result : " + result);
		
		result = var1 / var2;
		System.out.println("result : " + result);
		
		result = var1 % var2;
		System.out.println("result : " + result);
	}

}
