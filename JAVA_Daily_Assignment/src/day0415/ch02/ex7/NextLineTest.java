package day0415.ch02.ex7;
import java.util.Scanner;

public class NextLineTest {

	public static void main(String[] args) {

		//nextLine() 메서드로 공백 있는 문자열 입력받기
		Scanner sc = new Scanner(System.in);
		String message = null;
		System.out.println("메세지를 입력하세요.");
		message = sc.nextLine(); //문자열을 개행 기준으로 입력받음
		System.out.println(message);
		sc.close();
	}

}
