package day0417.ch07.ex1;

public class MethodEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score1 = {30, 40, 50, 60, 60};
		int max = 0;
		MethodEx1 m = new MethodEx1();
		
		max = m.arrayMax(score1);
		System.out.println("배열 최댓값 : "+max);
	}
	
	public int arrayMax(int[] arr) {
		//1.지역 변수 선언
		int max = 0;
		
		//2.기능 구현
		for (int i=0; i<arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

}
