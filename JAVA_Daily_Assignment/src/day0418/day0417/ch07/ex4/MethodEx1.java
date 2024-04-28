package day0417.ch07.ex4;

public class MethodEx1 {

	public static void main(String[] args) {
		//main() 메서드로 매개값 전달하기
		MethodEx1 m = new MethodEx1();
		m.print();
		m.print();
		m.print();
		
		System.out.println("종료");
	}
	
	public void print() {
		System.out.println("메서드를 호출합니다.");
	}

}
