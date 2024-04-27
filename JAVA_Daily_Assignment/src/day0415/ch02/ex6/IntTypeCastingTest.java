package day0415.ch02.ex6;

public class IntTypeCastingTest {

	public static void main(String[] args) {

		//정수의 타입을 강제로 변환하기
		byte bVar1 = 12;
		byte bVar2 = 17;
//		byte bVar3 = bVar1 + bVar2; // 자바에서는 byte 타입끼리의 연산 결과는 int 타입으로 자동 변환됨.
		byte bVar3 = (byte)(bVar1 + bVar2);
		System.out.println("bVar3 = " + bVar3);
		
//		bVar3 = 100 + 120; //byte 형인데 int를 적어주어서 에러남
		bVar3 = (byte)(100 + 120);
		System.out.println("bVar3 = " + bVar3);
		
		short sVar1 = 12;
		short sVar2 = 17;
//		short sVar3 = sVar1 + sVar2; // 자바에서 short 타입 데이터끼리 연산 결과는 int 타입으로 자동 변환됨
		short sVar3 = (short)(sVar1 + sVar2);
		System.out.println("sVar3 = " + sVar3);
		
//		sVar3 = 20000 + 22000; // 더하기의 결과값이 int 타입이므로 에러 발생
		sVar3 = (short)(20000 + 22000);
		System.out.println("sVar3 = " + sVar3);

		int iVar1 = 20000 + 22000;
		System.out.println("iVar1 = " + iVar1);
		
		int iVar2 =  (int)(3.141592);
		System.out.println("iVar2 = " + iVar2);
		
		int iVar3 = 5/2;
		System.out.println("iVar3 = " + iVar3);
		
		char cVar1 = 'A';
		int iVar4 = (int)cVar1;
		System.out.println("iVar4 = " + iVar4);
	}

}
