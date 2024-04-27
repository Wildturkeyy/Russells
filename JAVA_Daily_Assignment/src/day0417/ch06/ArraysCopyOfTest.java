package day0417.ch06;

import java.util.Arrays;

public class ArraysCopyOfTest {

	public static void main(String[] args) {
		// copyOf() 메서드와 copyOfRange()메서드로 배열 복사하기
		int[] arr1 = {10, 20, 30, 40, 50};
		
		int[] num1 = new int[5];
		for (int i=0; i<arr1.length; i++) {
			num1[i] = arr1[i];
		}
		System.out.println(Arrays.toString(num1));
		System.out.println();
		
		int[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(Arrays.toString(arr2));
		System.out.println();
		
		int[] arr3 = Arrays.copyOf(arr1, arr1.length-1);
		System.out.println(Arrays.toString(arr3));
		System.out.println();
		
		int[] arr4 = Arrays.copyOfRange(arr1, 1, 3);
		System.out.println(Arrays.toString(arr4));
		System.out.println();
		
		int[] arr5 = Arrays.copyOfRange(arr1, 3, arr1.length);
		System.out.println(Arrays.toString(arr5));
	}

}
