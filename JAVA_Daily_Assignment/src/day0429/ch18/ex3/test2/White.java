package day0429.ch18.ex3.test2;

public class White implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("백기 올려!");
        }
    }

    public void whiteFlag(int num){
        System.out.println(num + " : white flag!-----------");
    }
}
