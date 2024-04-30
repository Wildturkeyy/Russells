package day0430.ch25.ex4;

@FunctionalInterface
interface MyFuncInterface1{
    MyMath1 method();
}

class MyMath1{
    public MyMath1(){
        System.out.println("MyMath1 기본 생성자 호출");
    }

    public MyMath1(int a){
        System.out.println("매개 변수 한 개 MyMath1 생성자 호출");
    }

    public void print(int a, int b){
        System.out.println(a + b);
    }
}

//
public class ConstructorRefTest1 {
    public static void main(String[] args) {

        MyFuncInterface1 mfi1 = new MyFuncInterface1() {
            @Override
            public MyMath1 method() {
                return new MyMath1();
            }
        };
        MyMath1 myMath1 = mfi1.method();
        myMath1.print(10, 20);

        //
        MyFuncInterface1 mfi2 = () -> {
            return new MyMath1();
        };
        MyMath1 myMath12 = mfi2.method();
        myMath12.print(100, 200);

    }
}
