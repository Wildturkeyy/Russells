package day0430.ch18.ex6;

public class Food {
    // 필드 선언
    private static String[] menu = {"돈까스", "오므라이스", "된장찌개", "육개장"};
    String foodName;

    //주문 기능
    public void receiveOder(){
        synchronized (this){
            for(int i=0; i<5; i++){
                System.out.println("웨이터가 손님에게 주문을 받습니다.");
            }
            int menuNum = (int)(Math.random()*3) + 0;
            foodName = menu[menuNum]; // 메뉴에서 주문한 음식 저장

            System.out.println("웨이터가 " + foodName + " 주문을 주방에 전달합니다.\n");

            this.notify(); //정지 상태인 스레드를실행 상태로 이동
            try {
                this.wait(); //실행 중인 자신은 정지 상태로 이동
            }catch (InterruptedException e){}
        }
    }

    //주문 음식 요리
    public void makeFood(){
        synchronized (this){
            for (int i=0; i<5; i++){
                System.out.println("주방장이 " + foodName + " 을(를) 만듭니다.");
            }
            System.out.println("주방장이 " + foodName + " 을(를)다 만들었습니다.\n");

            this.notify();

            try {
                this.wait();
            }catch (InterruptedException e){}
        }
    }
}
