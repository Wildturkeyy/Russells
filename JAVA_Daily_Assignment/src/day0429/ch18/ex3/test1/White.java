package day0429.ch18.ex3.test1;

public class White extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("백기 올려!");
        }
    }
}
