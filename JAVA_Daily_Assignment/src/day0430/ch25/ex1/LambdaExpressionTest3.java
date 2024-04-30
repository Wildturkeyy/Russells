package day0430.ch25.ex1;

@FunctionalInterface
interface MyFuncInterface3 {
    public int methodC(int a, int b);
}


public class LambdaExpressionTest3 {
    public static void main(String[] args) {

        MyFuncInterface3 mfi1 = (int a, int b) -> {
            return a + b;
        };
        int result1 = mfi1.methodC(10, 20);

        //
        MyFuncInterface3 mfi2 = (a, b) -> {
            return a + b;
        };
        int result2 = mfi2.methodC(100, 200);

        //
        MyFuncInterface3 mfi3 = (a, b) -> a + b;
        int result3 = mfi3.methodC(1000, 2000);

        System.out.printf("결과1: %d, 결과2: %d, 결과3: %d", result1, result2, result3);


    }

}
