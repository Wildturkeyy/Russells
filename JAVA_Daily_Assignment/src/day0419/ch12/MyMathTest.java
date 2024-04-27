package day0419.ch12;

public class MyMathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result1 = MyMath.add(10, 20);
		System.out.println("두 수의 합: " +result1+ "\n");
		
		result1 = MyMath.substract(10, 20);
		System.out.println("두 수의 차: " +result1+ "\n");
		
		int radius = 10;
		double result2 = MyMath.pi * radius * radius;
		System.out.println("원의 넓이: " + result2+ "\n");
		
		result2 = Math.PI * radius * radius;
		System.out.println("원의 넓이: " + result2+ "\n");
		
		double random = Math.random();
		System.out.println("난수: " +random+ "\n");
		
		int result3 = (int)Math.sqrt(4);
		System.out.println("4의 제곱근: " + result3);
	}

}
