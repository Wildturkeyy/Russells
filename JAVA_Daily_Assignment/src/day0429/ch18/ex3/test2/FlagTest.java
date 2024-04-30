package day0429.ch18.ex3.test2;

public class FlagTest {
    public static void main(String[] args) {
//        White white = new White();
        Thread T1 = new Thread(new White());
        Thread T2 = new Thread(new Blue());
        // mian, T1, T2까지 3개 스레드 실행
        T1.start();
        T2.start();

        //
        new Thread((new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("파일 업로드 중입니다.");
                }
            }
        })).start();

        //
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        });
        t1.start();

    }
}
