package day0416.ch05.ex1;

import java.util.Scanner;

public class SwitchScoreTest {

	public static void main(String[] args) {
		// 시험점수를 입력받아서 결과 출력하기
		Scanner sc = new Scanner(System.in);
		System.out.println("시험 점수를 입력하세요");
		int score = Integer.parseInt(sc.nextLine());

		int mok = score / 10;
		
		switch (mok) {
		
		case 9, 10:
			System.out.println("매우 우수합니다");
			break;
		case 7, 8:
			System.out.println("우수합니다");
			break;
		case 5, 6:
			System.out.println("양호합니다");
			break;
		default:
			System.out.println("더 노력해야합니다.");
		}

		sc.close();

	}

}
