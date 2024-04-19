package day0417.ch06;

public class StringArrayCopyTest {

	public static void main(String[] args) {
		// System.arraycopy() 메서드로 문자열 배열 복사하기
		String[] strArr = {"apple", "banana", "orange", "mango", "lemon"};
		String[] strDest = new String[10];
		
		System.arraycopy(strArr, 0, strDest, 0, strArr.length);
		for (int i=0; i<strDest.length; i++) {
			System.out.print(strDest[i]+ " ");
		}
		System.out.println();
		
		int[] src1 = {10, 20, 30, 40, 50};
		int[] src2 = {60, 70, 80, 90, 100};
		int[] src3 = new int[10];
		System.arraycopy(src1, 0, src3, 0, src1.length);
		System.arraycopy(src2, 0, src3, src1.length, src2.length);
		for (int i=0; i<src3.length; i++) {
			System.out.print(src3[i]+" ");
		}

	}

}
