package day0422.ch12.rendercarApp.member;

public class MemberVO {
	//필드 선언
	String id;
	String password;
	String name;
	String address;
	String phoneNum;
	
	//생성자 선언
	public MemberVO(String id, String password, String name, String address, String phoneNum) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
	}

}
