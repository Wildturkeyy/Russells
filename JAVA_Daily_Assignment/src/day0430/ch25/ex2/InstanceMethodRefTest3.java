package day0430.ch25.ex2;

@FunctionalInterface
interface MyFuncInterface3{
    void method3();
}

class MyMath1{
    public void print(){
        System.out.println("prit() 메소드 호출");
    }
}

public class InstanceMethodRefTest3 {
    public static void main(String[] args) {
        MyMath1 myMath = new MyMath1();
        MyFuncInterface3 mfi = myMath::print;
        mfi.method3();
    }
}
