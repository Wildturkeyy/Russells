package day0422.ch13.test;

public interface ITest1 {
    public void test();
    
    default void realTest(){
        System.out.println("인터페이스에 기능을 설정해도 클래스에서 구현받아 사용가능");
    }
}
