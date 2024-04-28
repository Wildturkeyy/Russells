package day0415.ch02.ex6;

public class DataPromotionTest {

	public static void main(String[] args) {

		byte bVar1 = 12;
		int iVar1 = bVar1; //bVar의 값 12가 int 타입으로 자동으로 형변환
		System.out.println("iVar : " + iVar1);
		
		short sVar1 = 17;
		iVar1 = sVar1;
		System.out.println("iVar : " + iVar1);
		System.out.println();
		
		long lVar1 = bVar1;
		System.out.println(lVar1);
		lVar1 = sVar1;
		System.out.println(lVar1);
		lVar1 = iVar1;
		System.out.println(lVar1);
		System.out.println();
		
		System.out.println(lVar1 + 50.5F);
		
		float fVar1 = lVar1;
		System.out.println("fVar1 : " + fVar1);
		
		fVar1 = 103.25F;
		double dVar1 = fVar1;
		System.out.println("dVar1 : " + dVar1);
		
	}

}
