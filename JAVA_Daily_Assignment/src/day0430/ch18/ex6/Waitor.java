package day0430.ch18.ex6;

public class Waitor extends Thread{
    Food food;

    public Waitor(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        while (true){
            food.receiveOder();
        }
    }
}
