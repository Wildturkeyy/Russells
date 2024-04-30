package day0430.ch25.ex1;

@FunctionalInterface
interface MyFuncInterface {
    public void methodA();
}


public class LambdaExpressionTest1 {
    public static void main(String[] args) {
        MyFuncInterface mfi1 = () -> {
            System.out.println("methodA()1 호출");
        };

        mfi1.methodA();

        MyFuncInterface mfi2 = () -> System.out.println("methodA()2 호출");
        mfi2.methodA();
    }
}
