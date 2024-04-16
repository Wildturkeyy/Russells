package day0415.ch02.ex5;

public class BooleanTest {

	public static void main(String[] args) {

		// 논리 타입 데이터와 변수 사용하기
		boolean b1 = true;
//		boolean b1 = "true"; // 문자열 "true"를 저장하면 에러가 발생함
		System.out.println("b1 = " + b1);
		
//		b1 = 5; // 논리 타입 변수에는 true, false만 저장 가능
//		b1 = "false"; //에러 발생
		
		b1 = false;
		System.out.println("b1 = " + b1);

		if (b1) {
			System.out.println("참입니다.");
		}else {
			System.out.println("거짓입니다.");
		}
		
		boolean b2 = false;
		b2 = Boolean.parseBoolean("true"); // Boolean 클래스의 parseBoolean() 메서드를 사용해 "true"를 true로 변환
		System.out.println("b2 = "+ b2);
	}

}
