package day0429.ch17.renterCar.member;

import day0429.ch17.renterCar.common.exception.RentException;

public class MemberException extends RentException {

    public MemberException(String message){
        super(message);
    }
}
