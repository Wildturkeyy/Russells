package day0429.ch18.ex3.test2;

public class FlagTest2 {
    public static void main(String[] args) throws InterruptedException {
        White white = new White();

        // 메인 스레드에서 생성한 데몬 스레드
        Thread thread2 = new Thread(() -> {
            String superThread = Thread.currentThread().getName();
            // 데몬 스레드가 생성한 일반 스레드
            Thread thread5 = new Thread(() -> {
                while (true) {
                    System.out.println("호출 쓰레드 -> " + superThread);
                    System.out.println("현재 쓰레드 -> " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            });
            // 데몬 스레드가 생성하는 스레드는 default가 데몬 스레드
            // 이 데몬 스레드를 일반 스레드로 설정하고 실행을 시켜도
            // main 에서 실행한 스레드는 데몬 스레드
            // 그래서 해당 스레드는 종료가 되어야 한다고 생각

            thread5.setDaemon(true);
            // 데몬 스레드의 스레드의 작업
            System.out.println(">1몇 개: " + Thread.activeCount() + ", " +Thread.currentThread());
            System.out.println(">1 thread5: " + thread5.isDaemon());
            thread5.start();
            System.out.println(">2 실행중인 " + Thread.activeCount() +", " +Thread.currentThread());

            // 데몬 스레드의 작업
            white.whiteFlag(1);
        });

//        thread2.setDaemon(false);
        System.out.println(">3 thread2: " + thread2.isDaemon());
        System.out.println(">3 몇 개: " + Thread.activeCount() + ", " + Thread.currentThread());
        thread2.start();
        System.out.println(">4 몇 개: " + Thread.activeCount() + ", " +Thread.currentThread());
        Thread.sleep(1000);
        System.out.println("메인 스레드 종료");
    }
}