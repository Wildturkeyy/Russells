package day0424.ch16.ex4;

import java.util.Calendar;

public class UserDefinedException extends Exception {
		
	//
	public UserDefinedException() {}
	
	//예외 발생시 생성자로 예외 메시지를 전달
	public UserDefinedException(String message) {
		super(message);
	}
	
	//예외 발생 시각과 예외 메시지를 출력하는 메서드
	public String getUserExceptionInfo() {
		String errMsg = "예외 발생 시간: " + showTime() + " 예외 내용: " + super.getMessage();
		return errMsg;
	}
	
	//예외 발생 시각을 출력하는 메서드
	public static String showTime() {
		String date = null;
		String time = null;
		
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);
		
		date = year + "-" + month + "-" + day;
		time = hour + ":" + min + ":" +sec;
		
		return date + " " + time;
	}
	
	
	
	
}
