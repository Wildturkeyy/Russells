package day0415.ch02.ex7;
//Scanner import
import java.util.Scanner;

public class InputIntegerTest {

	public static void main(String[] args) {

		//Scanner 클래스 정수로 입력받기
		Scanner sc = new Scanner(System.in);
		int num1 = 0;
		
		System.out.println("정수를 입력하세요");
		String temp = sc.nextLine();
		num1 = Integer.parseInt(temp);
		
		System.out.println("입력한 정수는 "+num1+" 입니다.");
		sc.close();
	}

}
