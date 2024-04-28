package day0423.ch15.ex2.test1;

public class ToStringTest {
    public static void main(String[] args) {
        Student s = new Student("이순신", 24);

        System.out.println(s.toString());
        System.out.println(s); //자동으로 toString 메서드가 호출
    }
}
