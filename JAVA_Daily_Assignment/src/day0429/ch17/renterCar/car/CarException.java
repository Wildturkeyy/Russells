package day0429.ch17.renterCar.car;

import day0429.ch17.renterCar.common.exception.RentException;

public class CarException extends RentException {

    public CarException(String message){
        super(message);
    }

}
