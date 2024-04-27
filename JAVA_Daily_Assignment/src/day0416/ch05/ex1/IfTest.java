package day0416.ch05.ex1;

public class IfTest {

	public static void main(String[] args) {

		// if문 사용하기
		int score = 65;
		
		if (score == 65) {
			System.out.println("65점입니다.");
		}
		
		if (score >=60) {
			System.out.println("60점 이상입니다.");
			System.out.println("합격입니다");
		}
		
		if (score < 60) {
			System.out.println("60점 미만입니다.");
			System.out.println("불합격입니다.");
		}
	}

}
