package day0422.ch14.ex3;

public class Outter {

    public void startChat(){
        class ChattingThread{
            public void sendData(){
                System.out.println("메세지를 전송합니다.");
            }
            public void receiveData(){
                System.out.println("메세지를 수신합니다.");
            }
        }

        ChattingThread chat = new ChattingThread();
        chat.sendData();
        chat.receiveData();
    }

    public static void main(String[] args) {
        Outter outter = new Outter();
        outter.startChat();
    }
}
