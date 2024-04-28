package day0419.ch09.ex7;

public class Bus extends Car{
	private int passenger;
	private int fee;
	
	public Bus(String carName, String carNumber, String carColor, int velocity, int carSize, int passenger, int fee) {
		System.out.println("Bus 클래스 생성자 호출");
		super.carName = carName;
		super.carNumber = carNumber;
		super.carColor = carColor;
		super.velocity = velocity;
		super.carSize = carSize;
		this.passenger = passenger;
		this.fee =  passenger * fee;
	}
	
	public int getPassenger() {
		return passenger;
	}
	
	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}
	
	public int getFee() {
		return fee;
	}
	
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	//승객을 태우는 메서드
	public void ridePassenger() {
		//이상한데....
		if (passenger > 0) {
			passenger++;
			fee += 1000;
		}
	}
	
	public void ridePassenger(int cnt) {
		if (passenger > 0) {
			passenger+=cnt;
			fee += (1000*cnt);
		}
	}
	
	@Override
	public String getCarInfo() {
		return "차 이름: " +carName
		+ ",	차 번호: " +carNumber
		+ ",	차 색생: " +carColor
		+ ",	속도: " +velocity+ "km/h"
		+ ",	차 크기: " +carSize+ "cc"
		+ ",	승객수: "	+passenger+ "명"
		+ ",	승차요금: " +fee+ "원";
	}
}
