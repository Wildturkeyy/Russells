package day0422.ch13.ex3;

public class CarTest {
    public static void main(String[] args) {
//        Car 1 = new Car(); //인터페이스라 불러올 수 없음

        Truck t = new Truck();
        Car c = new SportsCar(); //인터페이스 타입으로 업캐스팅 가능

//        Car.SAFE_SPEED = 80; //인터페이스에서 설정된 상수는 모두 final임
        System.out.println("모든 차의 안전 속도: " + Car.SAFE_SPEED);
        System.out.println();

        t.speedUp();
        t.speedDown();
        t.stop();
        System.out.println();

        c.speedUp();
        c.speedDown();
        c.stop();
        System.out.println();

//        c.turbo(); // 업캐스팅 상태에서 구현 클래스의 메소드에 접근하면 에러
        SportsCar s = (SportsCar)c;
        s.turbo(); //다운 캐스팅 후 구현 클래스의 메소드에 접근


    }
}

