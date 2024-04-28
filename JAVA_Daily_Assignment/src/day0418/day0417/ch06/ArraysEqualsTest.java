package day0417.ch06;

import java.util.Arrays;

public class ArraysEqualsTest {

	public static void main(String[] args) {
		//equals() 메서드로 1차원 배열 동등 여부 확인하기
		int[] arr1 = {10, 20, 30, 40, 50};
		int[] arr2 = {10, 20, 30, 40, 50};
		int[] num1 = {10, 20, 30, 40, 55};
		boolean same = true;
		
		for (int i=0; i<arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				same = false;
				break;
			}
		}
		
		if (same==true) {
			System.out.println("두 배열은 같습니다.");
		}else {
			System.out.println("두 배열은 다릅니다.");
		}
		
		same = Arrays.equals(arr1, arr2);
		if (same == true) {
			System.out.println("두 배열은 같습니다.");
		}else {
			System.out.println("두 배열은 다릅니다.");
		}
		
		same = Arrays.equals(arr1, num1);
		if (same == true) {
			System.out.println("두 배열은 같습니다.");
		}else {
			System.out.println("두 배열은 다릅니다.");
		}
	}

}
