package day0429.ch17.renterCar.member;

import java.util.List;

public interface Member {

    public List<MemberVO> listMember() throws MemberException;

    public MemberVO viewMember(MemberVO memberVO) throws MemberException;

    public void regMember(MemberVO memberVO) throws MemberException;
    public void modMember(MemberVO memberVO) throws MemberException;
    public void delMember(MemberVO memberVO) throws MemberException;
}
