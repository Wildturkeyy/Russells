package day0429.ch17.renterCar.res;

import day0429.ch17.renterCar.common.AbstractBase;

import java.util.ArrayList;
import java.util.List;

public class ReserveImpl extends AbstractBase implements Reserve {
    List<ResVO> resList;

    public ReserveImpl(){
        resList = new ArrayList<>();
    }

    // 예약 정보 리스트 조회 기능
    @Override
    public List<ResVO> listResInfo() throws ResException {
        return resList;
    }

    //차 예약 정보 조회
    @Override
    public ResVO checkResInfo(ResVO resVO) throws ResException {
        String resNumber = resVO.getResNumber();
        ResVO requestedVO = null;

        for (int i=0; i<resList.size(); i++){
            requestedVO = resList.get(i);
            if (resNumber.equals(requestedVO.getResNumber())){
                break;
            }
            requestedVO = null;
        }
        return requestedVO;
    }

    //차 예약 기능
    @Override
    public void regResInfo(ResVO resVO) throws ResException {
        resList.add(resVO);
    }

    //차 예약정보 수정 기능
    @Override
    public void modResInfo(ResVO resVO) throws ResException {

    }

    @Override
    public void delResInfo(ResVO resVO) throws ResException {

    }
}
