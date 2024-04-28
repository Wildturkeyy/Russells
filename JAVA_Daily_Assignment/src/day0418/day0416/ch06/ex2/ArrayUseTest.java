package day0416.ch06.ex2;

public class ArrayUseTest {

	public static void main(String[] args) {
//		//배열 사용하기
//		int[] score = new int[5];
//		score[0] = 50;
////		score[0] = 50.6; //배열 선언시 사용한 타입 외에 다른 데이터를 저장할 수 없음
//		score[1] = 60;
//		score[2] = 70;
//		score[3] = 80;
//		score[4] = 90;
////		score[5] = 100; //6번째 요소는 존재하지 않으므로 값 저장시 ArrayIndexOutOfBoundsException 예외 발생
//		
//		int[] score2 = new int[] {50, 60, 70, 80, 90};
//		int[] score3 = {50, 60, 70, 80, 90};
//		
//		System.out.println("score[0] = "+score[0]);
//		System.out.println("score[1] = "+score[1]);
//		System.out.println("score[2] = "+score[2]);
//		System.out.println("score[3] = "+score[3]);
//		System.out.println("score[4] = "+score[4]);
//		
//		int total = score[0] + score[1] + score[2] + score[3] + score[4];
//		double average = total/5.0;
//		System.out.println("총점 : "+total);
//		System.out.println("평균 : "+average);
		
		//배열 사용하기
		int[] scores;
		scores = new int[5];
		for (int i=0; i<scores.length; i++) {
			System.out.println(scores[i]);
		}
		System.out.println();
		
		var size = 3;
		var name = new String[size];
		
		int[] scores2 = {50, 60, 70, 80, 90};
		int[] scores4;
		
	}

}
