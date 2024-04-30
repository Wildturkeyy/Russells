package day0429.ch18.ex4.daemon;

public class Horse extends Thread{
    private int horseNum;

    public Horse(int horseNum){
        this.horseNum = horseNum;
    }

    @Override
    public void run() {
        for (int i=1; i<10; i++){
            try {Thread.sleep(200);}catch (InterruptedException e){}
            System.out.println(horseNum+ "번말 " +100*i + "미터 통과");
        }
        System.out.println(horseNum + "번 말이 결승선 도착");
    }
}
