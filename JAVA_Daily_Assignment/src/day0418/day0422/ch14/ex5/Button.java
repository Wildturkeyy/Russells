package day0422.ch14.ex5;

public class Button {
    ButtonEventListener listener;

    public void addButtonEventListener(ButtonEventListener listener){
        this.listener = listener;
    }

    // 버튼 클릭시 인터페이스를 구현한 핸들러 메서드 호출
    public void btnClicked(String btnName){
        listener.btnClicked(btnName);
    }

    // 버튼 클릭시 수행할 추상 메서드를 가지는 내부인터페이스 선언
    static interface ButtonEventListener{
        public void btnClicked(String btnName);
    }
}
