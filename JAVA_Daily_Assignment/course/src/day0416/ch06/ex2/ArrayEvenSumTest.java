package day0416.ch06.ex2;

public class ArrayEvenSumTest {

	public static void main(String[] args) {
		//배열 초기화 후 짝수 번째 요소들의 합
		int[] scores = new int[10];
		int sum = 0;
		
		for (int i=0; i < scores.length; i++) {
			scores[i] = i * 10 + 10;
		}
		//짝수 번째 배열 요소들의 합을 구하는 코드
		for (int j=0; j<scores.length; j+=2) {
			sum += scores[j];
		}
		System.out.println(sum);
	}

}
