package day0419.ch09.ex7;

public class Car {
	protected String carName;
	protected String carNumber;
	protected String carColor;
	protected int velocity;
	protected int carSize;
	
	//생성자
	public Car() {
		System.out.println("Car 클래스 생성자 호출");
	}
	
	// 속도 메서드
	public void speedUp(int speed) {
		velocity += speed;
	}
	
	public void speedDown(int speed) {
		velocity -= speed;
	}
	
	public void stop() {
		velocity = 0;
	}
	
	//차 정보를 출력하는 메서드
	public String getCarInfo() {
		return "차 이름: " +carName
		+ ",	차 번호: " +carNumber
		+ ",	차 색생: " +carColor
		+ ",	속도: " +velocity+ "km/h"
		+ ",	차 크기: " +carSize+ "cc";
	}
}
