package day0418.ch08.ex1;

public class CallByString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String address = "서울시 강남구";
		CallByString str = new CallByString();
		
		System.out.println("메서드 호출 전");
		System.out.println("address = "+address);
		
		str.setAdress(address);
		System.out.println("\n메서드 호출 후");
		System.out.println("address = "+address);
		
	}
	
	public void setAdress(String addr) {
		addr = "수원시 장안구";
	}
}
