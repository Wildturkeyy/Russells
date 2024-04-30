package day0429.ch18.ex4;

public class MainMethodTest {
    public static void main(String[] args) {
        Thread curThread = Thread.currentThread(); //현재 실행 중인 스레드 객체에서 얻음
        System.out.println("현재 실행 ㅈ우인 스레드 객체 이름: " + curThread.getName());
        System.out.println("실행 중인 스레드 수: " + Thread.activeCount());
    }
}
