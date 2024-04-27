package day0416.ch04.ex5;

import java.util.Scanner;

public class DigitSumTest {

	public static void main(String[] args) {
		/*
		 * 세 자리의 정수를 콘솔로 입력받아 각 자릿수의 합을 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("세 자리의 정수를 입력하세요");
		int num = Integer.parseInt(sc.nextLine());
		
		int num1 = num/100;
		num %= 100;
		
		int num2 = num/10;
		num %= 10;
		
		System.out.printf("%d, %d, %d\n", num1, num2, num);
		System.out.println((num1+num2+num));

	}

}
