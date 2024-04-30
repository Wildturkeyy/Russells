package day0429.ch17.renterCar.member;

import day0429.ch17.renterCar.common.AbstractBase;

import java.util.ArrayList;
import java.util.List;

public class MemberImpl extends AbstractBase implements Member {
    List<MemberVO> memberList;

    public MemberImpl() {
        memberList = new ArrayList<>();
    }

    //기존 회원 리스트 조회
    @Override
    public List<MemberVO> listMember() throws MemberException {
        return memberList;
    }

    //기존 회원 정보 조회
    @Override
    public MemberVO viewMember(MemberVO memberVO) throws MemberException {
        String id = memberVO.getId();
        MemberVO memVO = null;

        for (int i=0; i<memberList.size(); i++){
            memVO = memberList.get(i);
            if(id.equals(memVO.getId())){
                break;
            }
            memVO = null;
        }
        return memVO;
    }

    //새로운 회원 등록
    @Override
    public void regMember(MemberVO memberVO) throws MemberException {
        String id = memberVO.getId();
        if(id == null || id.equals("")){
            System.out.println("아이디는 필수 입력 정보입니다.");
        }else{
            memberList.add(memberVO);
        }
    }

    //기존 회원 정보 수정
    @Override
    public void modMember(MemberVO memberVO) throws MemberException {
        String id = memberVO.getId();
        String password = memberVO.getPassword();
        String name = memberVO.getName();
        String address = memberVO.getAddress();
        String phoneNum = memberVO.getPhoneNum();

        MemberVO memVO = null;
        for (int i=0; i<memberList.size(); i++){
            memVO = memberList.get(i);
            if(id.equals(memVO.getId())){
                memVO.setPassword(password);
                memVO.setName(name);
                memVO.setAddress(address);
                memVO.setPhoneNum(phoneNum);
                break;
            }
        }
    }

    //기존 회원 정보 삭제
    @Override
    public void delMember(MemberVO memberVO) throws MemberException {
        MemberVO memVO = null;
        String id = memberVO.getId();
        for (int i=0; i<memberList.size(); i++){
            memVO = memberList.get(i);
            if (id.equals(memVO.getId())){
                memberList.remove(i);
            }
        }
    }
}
