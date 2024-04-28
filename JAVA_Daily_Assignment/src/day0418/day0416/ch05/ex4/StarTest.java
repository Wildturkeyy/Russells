package day0416.ch05.ex4;

import java.util.Scanner;

public class StarTest {

	public static void main(String[] args) {
		// Q1.
		for (int i=0; i<5; i++) {
			System.out.println("*****");
		}
		System.out.println();
		
		// Q2.
		for (int i=5; i>0; i--) {
			for (int j=i; j>0; j--) {
				System.out.printf("*");
			}
			System.out.println();
		}
		System.out.println();
		
		//Q3.1부터 자연수를 더할 때 그 합이 1000이상이 되게 하는 최초의 자연수와 그 합
		int num = 0;
		int sum = 0;
		while (sum<1000) {
			num++;
			sum += num;
		}
		System.out.println("sum : "+sum+" num : "+num);
		System.out.println();
		
		//Q4. 1부터 홀수들의 합이 1000이상이 되게 하는 자연수와 그 합
		int odd_num = 0;
		int odd_sum = 0;
		while (odd_sum<1000) {
			if (odd_num!=0) {
				odd_num+=2;
			}else {
				odd_num++;
			}
			odd_sum+=odd_num;
		}
		System.out.println("sum : "+odd_sum+" num : "+odd_num);
		System.out.println();
		
		//Q5. 양의 정수를 입력받아서 각 자리의 합을 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("양의 정수를 입력하세요.");
		int number = Integer.parseInt(sc.nextLine());
		int num_sum = 0;
		do {
			num_sum += (number%10);
			number /= 10;
		} while (number!=0);
		System.out.println(num_sum);
		
		
		
	}

}
