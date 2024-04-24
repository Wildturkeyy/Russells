package day0419.ch12;

public class Number {
	private int num;
	static int numCounter = 10;
	
	public static int getNumCounter() {
		return numCounter;
	}
	
	public static int getNumber() {
		int temp = 10+numCounter;
		return temp;
	}
	
	/*
	 * 정적 메서드에서는 인스턴스 필드 num에 접근할 수 없음
	public static int getNuber() {
		int result = num + 10;
		return result;
	}
	*/
	//생성자와 멤머 메서드에서 정적 필드에서는 정적 필드에 접근할 수 있음
	public Number() {
		num = numCounter;
	}
	
	public void increaseNum() {
		numCounter++;
	}
}
