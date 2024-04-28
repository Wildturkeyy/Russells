package day0422.ch14.ex4;

public class InnerTest {

    public static void main(String[] args) {
        Outter.Inner.tel = "010-1111-2222";
//        Outter.Inner.address = "주소"; //static이 아니라서 안됨
        String tel = Outter.Inner.getTel();
        System.out.println("전화번호: " + tel);
        System.out.println();

        Outter outter = new Outter("이순신", 17);
        Outter.Inner inner = new Outter.Inner("세종시 세종구");

        String name = outter.getName();
        int age = outter.getAge();

        System.out.println("고객정보");
        System.out.println("-------------------");
        System.out.println("이름: " + name);
        System.out.println("나이 : " + age);
        System.out.println(inner.getUserInfo());
    }
}
