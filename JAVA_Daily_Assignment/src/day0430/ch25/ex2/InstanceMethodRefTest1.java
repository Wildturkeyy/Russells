package day0430.ch25.ex2;

@FunctionalInterface
interface MyFuncInterface1{
    void methodA();
}

class MyMath{
    public void print(){
        System.out.println("print() 메소드 호출");
    }
}


public class InstanceMethodRefTest1 {
    public static void main(String[] args) {

        //
        MyFuncInterface1 mfi1 = new MyFuncInterface1() {
            @Override
            public void methodA() {
                MyMath myMath = new MyMath();
                myMath.print();
            }
        };
        mfi1.methodA();

        //
        MyFuncInterface1 mfi2 = () ->{
            MyMath myMath = new MyMath();
            myMath.print();
        };
        mfi2.methodA();

        //
    }
}
