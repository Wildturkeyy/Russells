package day0417.ch06;

public class TwoDimArrayValueSettingTest {

	public static void main(String[] args) {
		// p.261
		int[][] mat = new int[4][4];
		
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[i].length; j++) {
				if (i<=j) {
					mat[i][j] = 2;
				}else {
					mat[i][j] = 1;
				}
				
			}
		}
		
		//
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[i].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
		
	}

}
