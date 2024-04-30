package day0429.ch17.renterCar.car;

import java.util.List;

public interface Car {

    public List<CarVO> listCarInfo() throws CarException;

    public CarVO checkCarInfo(CarVO carVO) throws CarException;

    public void regCarInfo(CarVO carVO) throws CarException;

    public void modCarInfo(CarVO carVO) throws CarException;

    public void delCarInfo(CarVO carVO) throws CarException;
}
