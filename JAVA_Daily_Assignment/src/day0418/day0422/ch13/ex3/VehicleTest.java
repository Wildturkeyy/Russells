package day0422.ch13.ex3;

public class VehicleTest {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();

        Truck truck = vehicle.getTruck();
        truck.speedUp();
        truck.speedDown();
        truck.stop();
        System.out.println();

        Car car1 = vehicle.getTruck();
        car1.speedUp();
        car1.speedDown();
        car1.stop();
        System.out.println();

        Car car2 = vehicle.getSportsCar();
        car1.speedUp();
        car1.speedDown();
        car1.stop();
        System.out.println();

        SportsCar sportsCar = (SportsCar)vehicle.getSportsCar();
        sportsCar.turbo();
    }
}
