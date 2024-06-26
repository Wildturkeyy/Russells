package day0415.ch02.ex6;

public class FloatTypeCastingTest {

	public static void main(String[] args) {

		// 실수들의 강제 타입 변환
		float fVar1 = 3.25F;
//		fVar1 = 3.25; //double 타입을 대입하면 에러가 발생함
		fVar1 = (float)3.25; //double 타입 실수를 강제 형변환 후 float타입 변수에 대입한다.
		System.out.println("fVar1 = " + fVar1 + " 실수 여부 : " + Float.class.isInstance(fVar1));
		
		float fVar2 = 3.25F + 3.5F;
//		float fVar3 = 3.25F + 3.5; //두 개의 다른 실수를 더하면 결과값은 더 큰 double 타입의 실수가 된다.
		System.out.println("fVar2 = " + fVar2);
		
		float fVar3 = (float)(3.25F + 10.5); //더한 결과를 float로 강제 형변환 후 대입
		System.out.println("fVar3 = " + fVar3);
		
		double dVar1 = 13.25;
		System.out.println("dVar1 = " + dVar1);
		
		double dVar2 = 13.25F; // 작은 타입을 더큰 타입에 대입하면 자동으로 큰 타입으로 변환됨
		System.out.println("dVar2 = " + dVar2);
		
		double dVar3 = 5.25F + 13.5;
		System.out.println("dVar3 = " + dVar3);
		
		double dVar4 = 5/2.0; //정수를 double 타입 실수로 나누면 정수는 double 타입 실수로 변환된다
		System.out.println("dVar4 = " + dVar4);
		
		dVar4 = (double)5 / (double)2;
		System.out.println("dVar4 = " + dVar4);
		
		dVar4 = (double)5 /2;
		System.out.println("dVar4 = " + dVar4);
		
		final float  PI = 3.141592F;
		double area = 0.0;
		int radius = 15;
		area = PI * radius * radius;
		System.out.println("원의 넓이 : "+area);

		
	}

}
