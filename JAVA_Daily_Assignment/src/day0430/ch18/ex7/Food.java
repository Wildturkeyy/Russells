package day0430.ch18.ex7;

public class Food {
    private static String[] menuKorean = {"돈까스", "오므라이스", "된장찌개", "육개장"};
    private static String[] menuChina = {"짜장면", "짬뽕", "볶음밥", "탕수육"};
    String foodName;
    boolean isOrderReceived = false;
    static int choice = 0;

    //주문 받는 기능
    public void receiveOrder(Thread th) {
        synchronized (this) {
            String threadName = th.getName();
            if (isOrderReceived == false) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(threadName + "가 손님에게 주문을 받습니다.");
                }
                choice = (int) (Math.random() * 2);
                int menuNum = (int) (Math.random() * 4);
                if (choice == 0) {
                    foodName = menuKorean[menuNum];
                } else {
                    foodName = menuChina[menuNum];
                }

                System.out.println(threadName + "가 " + foodName + " 주문을 주방에 전달합니다.");
                isOrderReceived = true;
            }

            notifyAll();

            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    //주문 받은 음식을 요리하는 기은
    public void makeFood(Thread th) {
        synchronized (this) {
            String threadName = th.getName();
            if (choice == 0) { //한식
                if (threadName.equals("한식 주방장")) {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(threadName + "이 " + foodName + "를 만듭니다.");
                    }
                    System.out.println(threadName + "이 " + foodName + "를 다 만들었습니다.");
                    isOrderReceived = false;
                } else if (choice == 1) { //중식
                    if (threadName.equals("중식 주방장")) {
                        for (int i = 0; i < 5; i++) {
                            System.out.println(threadName + "이 " + foodName + "를 만듭니다.");
                        }
                        System.out.println(threadName + "이 " + foodName + "를 다 만들었습니다.");
                        isOrderReceived = false;
                    }
                }
            }
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }
}