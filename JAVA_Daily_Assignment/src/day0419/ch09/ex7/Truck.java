package day0419.ch09.ex7;

public class Truck extends Car{
	private int load; //적재화물량
	
	public Truck(String carName, String carNumber, String carColor, int velocity, int carSize, int load) {
		
		System.out.println("Truck 클래스 생성자 출력");
		super.carName = carName;
		super.carNumber = carNumber;
		super.carColor = carColor;
		super.velocity = velocity;
		super.carSize = carSize;
		this.load = load;
	}
	
	public int getLoad() {
		return load;
	}
	
	public void setLoad(int load) {
		this.load = load;
	}
	
	//화물을 운반하는 메서드
	public void carryLoad() {
		//이건 뭘 원하는겨...
		if (load>0) {
			load++;
		}else {
			load = 0;
		}
	}
	
	//
	@Override
	public String getCarInfo() {
		return "차 이름: " +carName
		+ ",	차 번호: " +carNumber
		+ ",	차 색생: " +carColor
		+ ",	속도: " +velocity+ "km/h"
		+ ",	차 크기: " +carSize+ "cc"
		+ ",	적재량: "	+load+ "톤";
	}
}
