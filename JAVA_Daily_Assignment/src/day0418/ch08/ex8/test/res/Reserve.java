package day0418.ch08.ex8.test.res;

public class Reserve {
	String resNumber;
	String resCarNumber;
	String resDate;
	String useBeginDate;
	String useEndDate;
	
	//생성자
	public Reserve() {
		
	}
	
	public Reserve(String _resNumber, String _resCarNumber, String _resDate, String _useBeginDate, String _useEndDate) {
		resNumber = _resNumber;
		resCarNumber = _resCarNumber;
		resDate = _resDate;
		useBeginDate = _useBeginDate;
		useEndDate = _useEndDate;
		
	}
	// 차 예약 조회 기능
	public String checkResInfo() {
		System.out.println("\n차 예약 정보를 조회합니다.");
		System.out.println("--------------------------");
		String resInfo = "예약 정보: "+resNumber
					  +"\n예약 차 번호: "+resCarNumber
					  +"\n예약일자: "+resDate
					  +"\n차 사용 시작 일자: "+useBeginDate
					  +"\n차 반납 예정 일자: "+useEndDate;
		return resInfo;
	}
	
	
}
