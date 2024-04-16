package day0416.ch05.ex3;

public class NestedForTest {

	public static void main(String[] args) {
		// 중첩 for문으로 반복 변수값 출력하기
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=5; j++) {
				System.out.printf("i = %d, j = %d\n", i, j);
			}
			System.out.println();
		}
		
		// 중첩 for문을 이용해서 시계의 시와 분 출력하기
		for (int hour=1; hour<=12; hour++) {
			for (int min=0; min<60; min+=10) {
				System.out.println(hour+"시 "+min+"분");
			}
			System.out.println();
		}
	}

}
