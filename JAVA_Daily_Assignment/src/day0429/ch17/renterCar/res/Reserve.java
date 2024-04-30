package day0429.ch17.renterCar.res;

import java.util.List;

public interface Reserve {
    public List<ResVO> listResInfo() throws ResException;

    public ResVO checkResInfo(ResVO resVO) throws ResException;

    public void regResInfo(ResVO resVO) throws ResException;
    public void modResInfo(ResVO resVO) throws ResException;
    public void delResInfo(ResVO resVO) throws ResException;
}
