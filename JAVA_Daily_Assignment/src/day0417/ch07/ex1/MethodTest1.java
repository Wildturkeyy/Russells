package day0417.ch07.ex1;

public class MethodTest1 {

	public static void main(String[] args) {
		//직육면체 부피를 구하는 메서드 구현하기
		int width1 = 10, length1 = 15, height1 = 30;
		int volume = 0;
		MethodTest1 m = new MethodTest1();
		
		volume = m.calcVolume(width1, length1, height1);
		System.out.println("첫 번째 직육면체의 부피 : " + volume);
		
		width1=12;
		length1 = 5;
		height1 = 51;
		volume = m.calcVolume(width1, length1, height1);
		System.out.println("두 번째 직육면체의 부피 : " + volume);
		System.out.println("세 번째 직육면체의 부피 : " + m.calcVolume(45, 10	, 5));
		
		
		
		
	}
	public int calcVolume(int width, int length, int height) {
		//지역변수 선언
		int vol = 0;
		
		//기능 구현
		vol = width * length * height;
		
		//결과값 출력 또는 리턴
		return vol;
	}

}
