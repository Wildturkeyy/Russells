package day0415.ch02.ex3;

public class MultiVarInitTest {
	public static void main(String[] args) {
		
		// 동시에 여러 변수 선언하기
//		int num1, num2, num3; //같은 타입의 변수를 ,를 이용해서 한 줄에 동시 선언
//		
//		num1 = 1;
//		num2 = 2;
//		num3 = 3;
		
		int num1 = 1, num2 = 2, num3 = 3; // 같은 타입의 변수를 ,를 이용해서 한 줄에 선언함과 동시에 초기화
		
		System.out.println("num1 = "+num1);
		System.out.println("num2 = "+num2);
		System.out.println("num3 = "+num3);
	}
}
