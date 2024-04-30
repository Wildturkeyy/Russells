package day0429.ch18.ex3.test1;

public class Blue extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("청기 올려!!");
        }
    }
}
