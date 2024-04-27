package day0416.ch05.ex4;

import java.util.Scanner;

public class WhileBreakTest {

	public static void main(String[] args) {

		// break문과 while문을 이용해서 메뉴 이름 출력하기
		int num = 0;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("------------------------------------------");
			System.out.println("1:회원, 2:렌터카, 3:예약, 4:종료");
			System.out.println("------------------------------------------");
			System.out.println("메뉴 번호 선택");
			int menu_num = Integer.parseInt(sc.nextLine());
			
			if (num==1) {
				System.out.println("회원 메뉴를 선택하셨습니다.");
			}else if (num==2) {
				System.out.println("렌터카 메뉴를 선택하셨습니다.");
			}else if (num==3) {
				System.out.println("예약 메뉴를 선택하셨습니다.");
			}else {
				System.out.println("종료합니다.");
				break;
			}
			
		}
		sc.close();
	}

}
