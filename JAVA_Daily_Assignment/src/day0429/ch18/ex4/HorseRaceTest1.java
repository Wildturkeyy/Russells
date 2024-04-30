package day0429.ch18.ex4;

public class HorseRaceTest1 {
    public static void main(String[] args) {
        for (int i=0; i<=10; i++){
            Thread horse = new Horse(i);
            horse.start();
        }
        System.out.println("메인 스레드 종료");
    }
}
