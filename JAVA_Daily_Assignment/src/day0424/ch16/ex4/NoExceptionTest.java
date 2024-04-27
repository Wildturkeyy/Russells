package day0424.ch16.ex4;

public class NoExceptionTest {

	public static void main(String[] args) {
		
		try {
			int[] num = new int[2];
			num[0] = 1;
			num[1] = 2;
			num[2] = 3; //ArrayIndexOutOfBoundsException: 예외 종료
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("베열의 범위를 벗어났습니다.");
		}
		System.out.println("프로그램 종료");
		
	}

}
