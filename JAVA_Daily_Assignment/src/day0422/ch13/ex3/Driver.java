package day0422.ch13.ex3;

public class Driver {

//    private  Car car = new Truck(); //필드 선언 후 바로 인스턴스로 업캐스팅 가능
    private Car car;

    public Driver(Car car){
        this.car = car;
    }

    public void drive(){
        car.speedUp();
        car.speedDown();
        car.stop();
    }

    public void truckDrive(){
        Car car = new Truck();
        car.speedUp();
        car.speedDown();
        car.stop();
    }

    public  void speedUp(Car car){
        if(car instanceof  Truck){
            Truck truck = (Truck)car;
            truck.speedUp();
        }else if (car instanceof SportsCar){
            SportsCar sportscar = (SportsCar)car;
            sportscar.speedUp();
        }
    }

}
