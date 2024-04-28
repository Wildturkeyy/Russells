package day0422.ch14.ex6;

public class Button {
    ButtonEventListener listener;

    public void addButtonEventListener(ButtonEventListener listener){
        this.listener = listener;
    }

    public void btnClicked(String btnName){
        listener.btnClicked(btnName);
    }
}
