package day0422.ch13.ex3;

public class Vehicle {

    public  Truck getTruck(){
        Truck truck = new Truck();
        return  truck;
    }

    public  Car getSportsCar(){
        SportsCar sportsCar = new SportsCar();
        return  sportsCar;
    }
}
