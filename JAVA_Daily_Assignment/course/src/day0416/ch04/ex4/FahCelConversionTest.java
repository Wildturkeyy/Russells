package day0416.ch04.ex4;

public class FahCelConversionTest {

	public static void main(String[] args) {
		// 연산자 우선순위
		// 화씨 섭시 온도 변환하기
		
		final int BASE = 32;
		float celsius = 0.0F, fahrenheit = 0.0F;
		
		celsius = 37.0F;
		fahrenheit = celsius * 0.9F / 0.5F + BASE; //연산자 우선순위가 같아도 가독성을 위해 괄호로 묶어줌
		fahrenheit = celsius * (0.9F / 0.5F) + BASE;
		System.out.println("섭씨: " + celsius +"도" + "-> 화씨: " +fahrenheit + "도");
		
		celsius = (fahrenheit - BASE) * 5.0F / 9.0F;
		celsius = (fahrenheit - BASE) * (5.0F / 9.0F);
		System.out.println("화씨: " +fahrenheit + "도 => 섭씨: " + celsius +"도");
		

	}

}
