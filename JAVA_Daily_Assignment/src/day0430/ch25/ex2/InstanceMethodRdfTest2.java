package day0430.ch25.ex2;

@FunctionalInterface
interface MyFuncInterface2{
    public void methodB(int k);
}

public class InstanceMethodRdfTest2 {
    public static void main(String[] args) {

        MyFuncInterface2 mfi = System.out::println;
        mfi.methodB(10);
    }

    //
//    MyFuncInterface1 mfi2 = k -> Math.abs(k);

}
