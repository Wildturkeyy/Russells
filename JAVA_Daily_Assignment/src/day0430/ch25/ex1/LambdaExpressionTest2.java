package day0430.ch25.ex1;

@FunctionalInterface
interface MyFuncInterface2{
    public void methodB(int a);
}

public class LambdaExpressionTest2 {
    public static void main(String[] args) {

        MyFuncInterface2 mfi1 = (int a)  -> {
            System.out.println(a);
        };

        mfi1.methodB(10);

        MyFuncInterface2 mfi2 = (a) -> System.out.println(a);

        mfi2.methodB(20);
    }
}
