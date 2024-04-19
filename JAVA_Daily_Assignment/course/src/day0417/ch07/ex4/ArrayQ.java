package day0417.ch07.ex4;

public class ArrayQ {

	public static void main(String[] args) {
		//메서드 호출 시 배열 요소들의 총합과 평균이 출력되도록 코딩
		int[] score = {66, 78, 90, 89, 91, 57};
		
		ArrayQ a = new ArrayQ();
		a.calcArray(score);
		
		System.out.println();
		System.out.println("종료");
	}
	public void calcArray(int[] arr) {
		int sum = 0;
		for (int i=0; i<arr.length; i++) {
			sum+=arr[i];
		}
		System.out.println("배열 요소 총합 : "+sum);
		System.out.println("배열 요소 평균 : "+(float)(sum)/arr.length);
	}

}
