package day0416.ch04.ex3;

import java.util.Scanner;

public class ConditionalOpTest {

	public static void main(String[] args) {

		//삼항 연산자 사용하기
		Scanner sc = new Scanner(System.in);
		System.out.println("시험 점수를 입력해 주세요");
		
		String temp = sc.nextLine();
		int score = Integer.parseInt(temp);
		String result = ((0 <= score) && (score <= 100)) ? "바르게 입력했습니다." : "다시 입력해주세요.";
		System.out.println(result);
		
		if ((0<= score) && (score <=100)) {
			result = "바르게 입력했습니다.";
		} else {
			result = "다시 입력해주세요.";
		}
		System.out.println(result);
		
	}

}
