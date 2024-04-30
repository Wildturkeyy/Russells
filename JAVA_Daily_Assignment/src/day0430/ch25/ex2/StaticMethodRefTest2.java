package day0430.ch25.ex2;

@FunctionalInterface
interface MyFuncInterface5{
    void methodA();
}

class MyMath5{
    public static void print(){
        System.out.println("print() 정적 메서드 호출");
    }
}

public class StaticMethodRefTest2 {
    public static void main(String[] args) {
        MyFuncInterface5 mfi = MyMath5::print;
        mfi.methodA();
    }
}
