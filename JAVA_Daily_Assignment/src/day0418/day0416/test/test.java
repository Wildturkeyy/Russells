package day0416.test;

public class test {

	public static void main(String[] args) {

		// 1)
		int x = 2, y = 1, z =0;
		System.out.println(y%2);
		z = x++ * 2 + x * (y%2);
		System.out.println(z);
		
		
		//2)
		int a = 3;
		a = a++;
		System.out.println(a);
	}

}
