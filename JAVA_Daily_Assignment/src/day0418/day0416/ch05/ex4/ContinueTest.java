package day0416.ch05.ex4;

public class ContinueTest {

	public static void main(String[] args) {

		// for문에서 continue 사용하기
		for (int i=1; i<=10; i++) {
			if(i%5==0) {
				continue;
			}
			System.out.println(i);
		}
		System.out.println("프로그램 종료");
	}

}
