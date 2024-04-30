package day0429.ch18.ex4;

public class Horse extends Thread{
    private int horseNum;

    public Horse(int horseNum) {
        this.horseNum = horseNum;
    }

    @Override
    public void run() {
        for (int i=0; i<= 10; i++){
            System.out.println(horseNum + "번 경마 우선순위: " + getPriority());
        }
        System.out.println(horseNum + "번 경마결승선 도착");
    }
}
