package day0424.ch16.ex4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsTest {
	
	public static int inputScore() throws InputMismatchException{
		int score = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		score = sc.nextInt();
		return score;
	}
	
	public static void main(String[] args) {
		try {
			int score = inputScore();
			System.out.println("입력 점수: " + score + "점");
		}catch (InputMismatchException e) {
			System.out.println("숫자만 입력 가능합니다.");
		}
		
		System.out.println("프로그램 종료");
	}
}
