package day0418.ch08.ex1;

import java.util.Arrays;

public class StudentScoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temp1 = {72, 77, 87, 88, 90};
		int[] temp2 = {67, 77, 81, 83, 91};
		StudentScoreInfo ss1 = new StudentScoreInfo();
		StudentScoreInfo ss2 = new StudentScoreInfo();
		ss1.name ="홍길동";
		ss1.scores = Arrays.copyOf(temp1, temp1.length);
		ss2.name = "이순신";
		ss2.scores = Arrays.copyOf(temp2, temp2.length);
		
		ss1.printAvg();
		ss2.printAvg();

	}

}
