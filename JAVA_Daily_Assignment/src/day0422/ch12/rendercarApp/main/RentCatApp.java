package day0422.ch12.rendercarApp.main;

import day0422.ch12.rendercarApp.res.Reserve;
import day0422.ch12.rendercarApp.car.Car;
import day0422.ch12.rendercarApp.car.CarVO;
import day0422.ch12.rendercarApp.member.Member;
import day0422.ch12.rendercarApp.member.MemberVO;
import day0422.ch12.rendercarApp.res.ResVO;

public class RentCatApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String memData;
		String carData;
		String resData;
		
		System.out.println("----------------------------------------------");
		MemberVO  memberVO = new MemberVO("lee", "1234", "이순신", "서울", "01012341234");
		
		Member member = new Member();
		member.regMember(memberVO); //회원 가입하기
		memData = member.viewMember(memberVO);//회원 정보 조회하기
		member.displayData(memData);
		System.out.println("----------------------------------------------");
		System.out.println();
		
		CarVO carVO = new CarVO("11가1111", "소나타", "검정", 2000, "현대");
		Car car = new Car();
		car.regCarInfo(carVO); //새 차 정보 등록
		carData = car.checkCarInfo(carVO); // 차 정보 조회
		car.displayData(carData);
		System.out.println("----------------------------------------------");
		System.out.println();
		
		ResVO resVO = new ResVO("20220708-0001", "11가1111", "2022-04-30", "2022-05-01", "2022-05-08");
		Reserve reserve = new Reserve();
		reserve.resCar(resVO); //차 예약하기
		resData = reserve.checkResInfo(resVO);
		reserve.displayData(resData);
	}

}
