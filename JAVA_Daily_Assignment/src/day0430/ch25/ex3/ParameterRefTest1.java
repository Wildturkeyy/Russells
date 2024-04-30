package day0430.ch25.ex3;

@FunctionalInterface
interface MyfuncInterface1{
    void method(MyMath1 myMath, int a, int b);
}

class MyMath1{
    public void print(int a, int b){
        System.out.println(a+b);
    }
}

//
public class ParameterRefTest1 {
    public static void main(String[] args) {

        MyfuncInterface1 mfi1 = new MyfuncInterface1() {
            @Override
            public void method(MyMath1 myMath, int a, int b) {
                myMath.print(a, b);
            }
        };
        mfi1.method(new MyMath1(), 10, 20);

        //
        MyfuncInterface1 mf2 = (myMath, a, b) -> {
            myMath.print(a, b);
        };
        mf2.method(new MyMath1(), 100, 200);
    }
}
