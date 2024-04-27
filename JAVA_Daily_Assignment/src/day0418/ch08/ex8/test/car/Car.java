package day0418.ch08.ex8.test.car;

public class Car {
	String carNumber;
	String carName;
	String carColor;
	int carSize;
	String carMaker;
	
	//생성자
	public Car() {
		
		
	}
	
	public Car(String _carNumber, String _carName, String _carColor, int _carSize, String _carMaker) {
		carNumber = _carNumber;
		carName = _carName;
		carColor = _carColor;
		carSize = _carSize;
		carMaker = _carMaker;
	}
	
	//차 정보 조회
	public String checkCarInfo() {
		System.out.println("\n렌터카 정보를 조회합니다.");
		System.out.println("------------------------");
		String carInfo = "차 번호: "+carNumber
					  +"\n차 이름: "+carName
					  +"\n차 색상: "+carColor
					  +"\n차 크기: "+carSize
					  +"\n차 제조사: "+carMaker;
		return carInfo;
	}
	
	//차 정보 등록
	public void regCarInfo(String _carNumber, String _carName, String _carColor, int _carSize, String _carMaker) {
		System.out.println("\n렌터카 정보를 조회합니다.");
		System.out.println("------------------------");
		carNumber = _carNumber;
		carName = _carName;
		carColor = _carColor;
		carSize = _carSize;
		carMaker = _carMaker;
	}
	
	//차 정보 수정
	public void modCarInfo() {
		System.out.println("\n렌터카 정보를 수정합니다.");
	}
	
	//차 정보 삭제
	public void delCarInfo() {
		System.out.println("\n렌터카 정보를 삭제합니다.");
	}
}
