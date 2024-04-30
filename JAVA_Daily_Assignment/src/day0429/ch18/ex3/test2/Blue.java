package day0429.ch18.ex3.test2;

public class Blue implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("청기 올려!");
        }
    }
}
