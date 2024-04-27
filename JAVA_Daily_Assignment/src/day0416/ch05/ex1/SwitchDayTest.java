package day0416.ch05.ex1;

import java.util.Scanner;

public class SwitchDayTest {

	public static void main(String[] args) {

		// switch문을 이용해서 요일 출력하기
		Scanner sc = new Scanner(System.in);
		System.out.println("요일을 입력해주세요.");
		String day = sc.nextLine();
		
		switch(day) {
		case "월요일":
			System.out.println("월요일입니다.");
			break;
		case "화요일", "화":
			System.out.println("화요일입니다.");
			break;
		default:
			System.out.println("무슨 요일인지 알 수 없음");
		}
		
		sc.close();
	}

}
