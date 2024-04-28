package day0422.ch13.ex5;

public class MemberImpl implements MemberPC, MemberMobile{
    @Override
    public void joinMemberMobile() {
        //모바일 회원가입 기능
        System.out.println("모바일에서 회원 가입 합니다.");
    }

    @Override
    public void searchMemberMobile() {
        //모바일 회원 조회 기능
        System.out.println("모바일에서 회원 조회 합니다.");
    }

    @Override
    public void modMemberMobile() {
        //모바일 회원 수정 기능
        System.out.println("모바일에서 회원 수정 합니다.");
    }

    @Override
    public void delMemberMobile() {
        //모바일 회원 삭제 기능
        System.out.println("모바일에서 회원 삭제합니다.");
    }

    @Override
    public void joinMember() {
        //PC 회원 가입 기능
        System.out.println("PC에서 회원 가입합니다.");
    }

    @Override
    public void searchMember() {
        //PC 회원 조회 기능
        System.out.println("PC에서 회원 조회합니다.");
    }

    @Override
    public void monMember() {
        //PC에서 회원 수정합니다.
        System.out.println("PC에서 회원 수정합니다.");
    }

    @Override
    public void delMember() {
        //PC에서 회원 삭제합니다.
        System.out.println("PC에서 회원 삭제합니다.");
    }
}
