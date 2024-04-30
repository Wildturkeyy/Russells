package day0429.ch17.renterCar.common;

import day0429.ch17.renterCar.car.CarVO;

import java.util.List;

public class AbstractBase {
    //렌터카 프로그램 상위 메뉴 목록
    public static final int MENU_END = 0;
    public static final int MENU_MEMBER = 1;
    public static final int MENU_CAR = 2;
    public static final int MENU_RES = 3;

    //렌터카 프로그램 하위 메뉴 목록
    public static final int MENU_MEMBER_LIST = 1;
    public static final int MENU_MEMBER_VIEW = 2;
    public static final int MENU_MEMBER_REG = 3;
    public static final int MENU_MEMBER_MOD = 4;
    public static final int MENU_MEMBER_DEL = 5;

    public static final int MENU_CAR_LIST = 1;
    public static final int MENU_CAR_VIEW = 2;
    public static final int MENU_CAR_REG = 3;
    public static final int MENU_CAR_MOD = 4;
    public static final int MENU_CAR_DEL = 5;

    public static final int MENU_RES_LIST = 1;
    public static final int MENU_RES_VIEW = 2;
    public static final int MENU_RES_REG = 3;
    public static final int MENU_RES_MOD = 4;
    public static final int MENU_RES_DEL = 5;

    public static List<CarVO> carList; //리스트로 렌터카 정보 저장, 예약 기능에서도 사용할 수 있도록 부모 클래스에서 선언

    //하위 클래스의 결과값을 출력하는 메서드
//    public void displayData(List<? extends Object> listData){
//        if (listData == null || listData.size() == 0){
//            System.out.println("조회한 데이터가 없습니다.");
//        }else {
//            Object obj = listData.get(0);
//
//            if (obj instanceof MemberVO){
//                System.out.println("\n회원 리스트");
//                System.out.println("-------------------------------------");
//                for (int i=0; i<listData.size(); i++){
//                    obj = listData.get(i);
//                    MemberVO memberVO = (MemberVO) obj;
//                    String id = memberVO.getID();
//                }
//
//            }
//        }
//    }

}
