package day0416.ch04.ex5;

import java.util.Scanner;

public class OddEvenTest {

	public static void main(String[] args) {
		/*
		 * 한 개의 정수를 입력받아 홀수, 짝수판볗하기
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요.");
		int num = Integer.parseInt(sc.nextLine());
		
		String result = (num%2 == 1)?"홀수":"짝수";
		System.out.printf("입력한 %d은(는) %s입니다.", num, result);
		
	}

}
