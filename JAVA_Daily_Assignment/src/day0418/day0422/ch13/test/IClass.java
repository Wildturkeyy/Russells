package day0422.ch13.test;

public class IClass implements ITest2, ITest3{
    @Override
    public void method2() {
        System.out.println("method2() 실행");
    }

    @Override
    public void method3() {
        System.out.println("method3() 실행");
    }

    @Override
    public void test() {
        System.out.println("ITest1 test() 실행");
    }
}
