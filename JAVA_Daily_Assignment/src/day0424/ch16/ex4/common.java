package day0424.ch16.ex4;

public class common {

	public static void main(String[] args) {

		int[] num = new int[2];
		test(num);
		

	}
	
	static void test(int[] arr) {
		try {
			arr[0] = 1;
			arr[1] = 2;
//			arr[2] = 3;
			
			arr[1] = 3/0;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 범위를 벗어났습니다.");
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("파이널리");
		}
		
		System.out.println("프로그램 종료");
	}

}
