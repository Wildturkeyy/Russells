package day0424.ch16.ex4;

public class MultyTryCatchTest {

	public static void main(String[] args) {
		
		//멀티 try~catch
//		try {
//			int[] num = new int[2];
//			num[0] = 1;
//			num[1] = 2;
//			num[2] = 3;
//			
//			num[1] = 3/0;
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("배열의 범위를 벗어났습니다.");
//		}catch(ArithmeticException e) {
//			System.out.println("0으로 나눌 수 없습니다.");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}

		
//		System.out.println("프로그램을 종료합니다.");
//		
		// 멀티 catch 기능
//		try {
//			int[] num = new int[2];
//			num[0] = 1;
//			num[1] = 2;
//			num[2] = 3;
//			
//			num[1] = 3/0;
//		}catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
//			System.out.println("실행 예외가 발생했습니다.");
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		//finally 구문 실행하기
		try {
			int[] num = new int[2];
			num[0] = 1;
			num[1] = 2;
//			num[2] = 3;
			
			num[1] = 3/0;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 범위를 벗어났습니다.");
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("finally구문은 항상 실행됩니다.");
		}
		
		
		System.out.println("프로그램 종료");
	}
}
