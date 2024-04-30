package day0430.ch25.ex3;

@FunctionalInterface
interface MyFuncInterface2{
    void method(MyMath2 myMath, int a, int b);
}

class MyMath2{
    public void print(int a, int b){
        System.out.println(a + b);
    }
}

//
public class ParameterRefTest2 {
    public static void main(String[] args) {

        MyFuncInterface2 mfi = MyMath2::print;
        mfi.method(new MyMath2(), 1000, 2000);
    }
}
