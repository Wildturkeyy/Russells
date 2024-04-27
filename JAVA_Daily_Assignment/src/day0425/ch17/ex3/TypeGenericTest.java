package day0425.ch17.ex3;

public class TypeGenericTest {

	public static void main(String[] args) {
		GOrigin<String> origin1 = new GOrigin<String>();
		String str = "안녕하세요";
		origin1.setData(str);
//		origin1.setData(Integer.valueOf(300)); //String 타입 외에 다른 타입을 메소드로 전달 시 에러 발생
		String result1 = origin1.getData();
		String result2 = (String)origin1.getData();
		System.out.println("1 " + result1 + "  2 " + result2);
		
		
		GOrigin<Integer> origin2 = new GOrigin<Integer>();
	}

}
