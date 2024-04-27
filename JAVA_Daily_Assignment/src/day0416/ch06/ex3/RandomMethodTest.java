package day0416.ch06.ex3;

public class RandomMethodTest {

	public static void main(String[] args) {
		//1에서 100 사이의 정수 구하기
		System.out.println(Math.random());
		
		int num = (int)(Math.random() * 100);
		System.out.println(num); //0~ 99
		
		
	}

}
