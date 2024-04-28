package day0422.ch14.ex5;

public class ButtonEventHandler implements Button.ButtonEventListener{
    @Override
    public void btnClicked(String btnName) {
        System.out.println("버튼을 클릭합니다.");
    }
}
