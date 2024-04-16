package day0416.ch05.ex2;

public class DoWhilePrintFrom1To5Test {

	public static void main(String[] args) {
		// do-while문을 이용해서 1에서 5까지 출력하기
		int i = 1;

		do {
			System.out.println("i = " + i);
			i++;
		} while (i <= 5);
		
		System.out.println("do-while문 밖에서의 i값: " + i);
		System.out.println();
		
		// do-while문을 이용해서 1에서 5까지의 합 구하기
		int sum = 0;
		i = 1;
		
		do {
			sum+=i;
			i++;
		} while(i<=5);
		System.out.println("1에서 5까지의 합 : "+sum);
	}

}
