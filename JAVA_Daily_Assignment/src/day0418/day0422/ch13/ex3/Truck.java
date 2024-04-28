package day0422.ch13.ex3;

public class Truck implements Car{
    
    @Override
    public void speedUp() {
        System.out.println("트럭이 속도를 높입니다.");
    }

    @Override
    public void speedDown() {
        System.out.println("트럽이 속도를 낮춥니다.");
    }

    @Override
    public void stop() {
        System.out.println("트럭이 멈춥니다.");
    }
}
