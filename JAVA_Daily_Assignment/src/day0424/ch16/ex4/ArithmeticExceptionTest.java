package day0424.ch16.ex4;

public class ArithmeticExceptionTest {

	public static void main(String[] args) {
		/*
		 * 발생했던 에러
		 * No exception of type ArithmeticException can be thrown; an exception type must be a subclass of Throwable
		 * class name 뒤에 실수로 Test를 빼고 class명을 지음 > 기존에 존재했던 명칭과 동일한 객체를 만들면 이런 에러가 발생함
		 * 이름 지을 때 주의
		 */
		
		try {
			int num = 3;
			int result = num/0;
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		System.out.println("프로그램 종료");
	}

}
