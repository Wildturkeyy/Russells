package day0422.ch13.ex5;

public class MemberTest {

    public static void main(String[] args) {
        MemberPC memberpc = new MemberImpl();
        memberpc.joinMember();

        MemberMobile memberMobile = new MemberImpl();
        memberMobile.joinMemberMobile();
    }
}
