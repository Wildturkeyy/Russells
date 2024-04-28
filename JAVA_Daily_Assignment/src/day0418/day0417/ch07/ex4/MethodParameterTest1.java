package day0417.ch07.ex4;

public class MethodParameterTest1 {

	public static void main(String[] args) {
		// 매개변수가 한 개인 메서드 사용하기
		int a = 10;
		String str = "안녕하세요.";
		
		MethodParameterTest1 m = new MethodParameterTest1();
		m.print(5);
		m.print(10);
		m.print(15);
		
		m.printResult(str);
	}
	
	public void print(int x) {
		System.out.println("전달된 값: "+x);
	}
	
	public void printResult(String result) {
		System.out.println(result);
	}

}
