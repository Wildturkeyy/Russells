package day0417.ch07.ex1;

import java.util.Scanner;

public class MethodTestQ {

	public static void main(String[] args) {
		// 시작 정수화 마지막 정수 입력 순서에 관계없이 두 정수 사이의 정수들의 합을 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("첫 번째 정수 입력");
		int start = Integer.parseInt(sc.nextLine());
		System.out.println("두 번째 정수 입력");
		int end = Integer.parseInt(sc.nextLine());
		
		MethodTestQ m = new MethodTestQ();
		m.sum(start, end);
	}
	public void sum(int start, int end) {
		int total = 0;
		if (start > end) {
			int temp = start;
			start = end;
			end = temp;
		}
		for (int i=start; i<=end; i++) {
			total += i;
		}
		System.out.println(start+"와 "+end+" 사이의 정수들의 합 : "+total);
	}

}
