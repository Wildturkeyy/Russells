package day0415.ch04.ex2;

public class LogicalOpTest {

	public static void main(String[] args) {
		// 논리 연산자 사용하기
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
		
		System.out.println(!false);
		System.out.println(false ^ false); // 좌, 우측 값이 같으면 fasle 리턴
		System.out.println(true ^ false); // 좌, 우측 값이 다르면 true 리턴
		
		int a = 10, b = 10, c = 20;
		boolean result = (a==b) && (b==c);
		System.out.println(result);
		
		result = (a==b) || (b==c);
		System.out.println(result);
		System.out.println(!result);
		
	}

}
