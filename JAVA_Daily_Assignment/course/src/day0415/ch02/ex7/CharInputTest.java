package day0415.ch02.ex7;
import java.util.Scanner;

public class CharInputTest {

	public static void main(String[] args) {
		// 문자열 입력받고 대문자로 바꾸기
		Scanner sc = new Scanner(System.in);
		char grade;
		
		System.out.println("학점을 입력하세요");
		String temp = sc.nextLine();
		grade = temp.toUpperCase().charAt(0);
		
		System.out.println("학점 : " + grade);
	}

}
