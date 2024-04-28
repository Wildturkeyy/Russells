package day0417.ch07.ex1;

import java.util.Scanner;

public class MethodTest2 {

	public static void main(String[] args) {
		//두 수 사이의 정수들의 합 구하기
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수를 입력하세요.");
		System.out.println("시작 정수 : ");
		int start = Integer.parseInt(sc.nextLine());
		
		System.out.println("마지막 정수 : ");
		int end = Integer.parseInt(sc.nextLine());
		
		MethodTest2 m = new MethodTest2();
		m.sum(start, end);
	}
	
	public void sum(int start, int end) {
		//지역 변수 선언
		int total=0;
		
		for (int i=start; i<=end; i++) {
			total += i;
		}
		
		System.out.println("---결과 출력---");
		System.out.println(start+"와 "+end+" 사이 정수들의 합 : "+total);

	}

}
