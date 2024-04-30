package day0430.ch25.ex2;

@FunctionalInterface
interface MyFuncInterface4{
    double methodA();
}

class MyMath3{
    public double print(){
        return Math.random();
    }
}

//
public class StaticMethodRefTest1 {
    public static void main(String[] args) {
        MyFuncInterface4 mfi = Math::random;
        double result = mfi.methodA();
        System.out.println(result);
    }
}
