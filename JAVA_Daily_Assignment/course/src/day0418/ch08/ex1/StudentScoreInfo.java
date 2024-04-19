package day0418.ch08.ex1;

import java.util.Arrays;

public class StudentScoreInfo {
	String name;
	int[] scores = new int[5];

	public void ArrayScore() {
		int[] temp = new int[5];
		temp = Arrays.copyOf(scores, scores.length);
		Arrays.sort(temp);
		System.out.printf("%s의 시험 점수 : %d, %d, %d, %d, %d\n", name, temp[4], temp[3], temp[2], temp[1], temp[0]);
	}
	
	public void printAvg() {
		ArrayScore();
		int sum=0;
		for (int i=0; i<scores.length; i++) {
			sum+=scores[i];
		}
		System.out.println("총점 : "+sum);
		System.out.println("평균 : "+(float)sum/5);
	}
}
