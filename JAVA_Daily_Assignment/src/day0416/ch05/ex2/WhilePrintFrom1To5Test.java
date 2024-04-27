package day0416.ch05.ex2;

import java.util.Scanner;

public class WhilePrintFrom1To5Test {

	public static void main(String[] args) {

		// while문으로 반복 변수 값 출력하기
		int i = 1;
		while (i<=5) {
			System.out.printf("%d ", i);
			i++;
		}
		System.out.printf("\nwhile문 밖에서 i의 값 : %d\n\n", i);
		
		// while문을 이용해서 1에서 5까지의 합 구하기
		int sum = 0;
		i = 1;
		while (i<=5) {
			sum += i;
			i++;
		}
		System.out.println("1에서 5까지의 합 : "+sum);
		System.out.println();
		
		// while문을 이용해서 1과 키보드로 입력받은 자연수 사이의 짝수들의 합을 구해보세요.
		Scanner sc = new Scanner(System.in);
		sum = 0; i=0;
		System.out.println("1 이상의 정수를 입력하세요");
		int num = Integer.parseInt(sc.nextLine());
		while (i<num) {
			sum+=i;
			i+=2;
		}
		System.out.println("1에서 5까지의 합 : "+sum);
		System.out.println();
		
		
	}

}
