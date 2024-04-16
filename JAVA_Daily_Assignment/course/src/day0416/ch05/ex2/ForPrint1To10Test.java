package day0416.ch05.ex2;

public class ForPrint1To10Test {

	public static void main(String[] args) {

		// for문을 이용해서 1에서 10까지 출력하기
		for (int i = 1; i<=10; i++) {
			System.out.println(i);
		}
		System.out.println();
		
		// for문을 이용해서 1에서 5까지의 합 구하기
		int sum = 0;
		for (int i=1; i<=5; i++) {
			sum+=i;
		}
		System.out.println("1~5의 합 : "+sum);
		System.out.println();
		
		// for문을 이용해서 화씨 온도를 섭씨 온도로 변환하기
		final int BASE = 32;
		float celsius = 0.0F;
		
		for (int fahrenheit =0; fahrenheit <=100; fahrenheit += 10) {
			celsius = (fahrenheit - BASE) * (5.0F / 9.0F);
			System.out.printf("화씨 : %d \t 섭씨 : %.3f\n", fahrenheit, celsius);
			 
		}
		System.out.println();
		
		// 퀴즈 : for문을 이용해서 1에서 10사이의 짝수들의 합을 구하세요
		int evenSum = 0;
		for (int i = 2; i<10; i+=2) {
			evenSum += i;
		}
		System.out.println("짝수들의 합 : " + evenSum);
		System.out.println();
		
	}

}
