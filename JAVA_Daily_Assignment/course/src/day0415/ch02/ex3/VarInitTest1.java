package day0415.ch02.ex3;

public class VarInitTest1 {

	public static void main(String[] args) {

		int num;
//		System.out.println(num); // 변수를 초기화하지 않고 출력시 에러 발생
		
		num = 12;
//		int num = 12; // 이미 int 변수로 선언된 것은 두 번 선언할 수 없음. / 변수 선언 및 초기화를 한 번에 하는 방법
//		num = 2.5; // 변수에는 선언한 타입의 값만 저장할 수 있음
		
		System.out.println(num);
		
		System.out.println("num = "+num);
		num = 30;
		System.out.println("num = "+num);
		
	}

}
