package day0422.ch13.ex3;

public class SportsCar implements Car{
    @Override
    public void speedUp() {
        System.out.println("스포츠카가 속도를 높입니다.");
    }

    @Override
    public void speedDown() {
        System.out.println("스포츠카가 속도를 낮춥니다.");
    }

    @Override
    public void stop() {
        System.out.println("스포츠카가 멈춥니다.");
    }

    public void turbo(){
        System.out.println("스포츠카 고속 질주 기능입니다.");
    }
}
