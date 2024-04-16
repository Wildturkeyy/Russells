package day0416.ch04.ex5;

import java.util.Scanner;

public class MaxValueTest {

	public static void main(String[] args) {

		/*
		 * 두 개의 양수를 콘솔에서 입력받아 두 양수 중 큰 수를 출력해주세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("두 개의 정수를 입력하세요.");
		
		int num1 = Integer.parseInt(sc.nextLine());
		int num2 = Integer.parseInt(sc.nextLine());
		
		int result = (num1 > num2)?num1:num2;
		System.out.printf("입력한 두 정수 %d, %d 중 더 큰 수는 %d입니다.", num1, num2, result);
	}

}
