package day0430.ch25.ex4;

@FunctionalInterface
interface MyFuncInterface2{
    MyMath2 method();
}

class MyMath2{
    public MyMath2(){
        System.out.println("MyMath2 기본 생성자 호출");
    }

    public MyMath2(int a){
        System.out.println("MyMath 매개 변수 한 개 생성자 호출");
    }

    public  void print(int a, int b){
        System.out.println(a+b);
    }
}

//
public class ConstructorRefTest2 {
    public static void main(String[] args) {

        MyFuncInterface2 mfi = MyMath2::new;
        MyMath2 myMath = mfi.method();
        myMath.print(1000, 2000);
    }
}
