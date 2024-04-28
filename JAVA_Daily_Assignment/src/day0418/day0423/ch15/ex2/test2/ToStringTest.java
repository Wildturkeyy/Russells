package day0423.ch15.ex2.test2;

public class ToStringTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s = new Student("이순신", 2);

        System.out.println(s.toString());
        System.out.println(s); //자동으로 toString 메서드가 호출
        System.out.println();

        Student s1 = new Student("나나나", 2);
        Student s2 = (Student) s1.clone();

        System.out.println(s1.toString());
        System.out.println(s2.toString()); //교재가 이상한거 같음

    }
}
