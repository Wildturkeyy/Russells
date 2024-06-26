package day0415.ch02.ex5;

public class BinOctHexTest {

	public static void main(String[] args) {

		int num1 = 200;
		int bin = 0b11010011;
		int oct = 0110;
		int hex = 0x13FC;
		
		System.out.println("num = " + num1);
		System.out.println("bin = " + bin);
		System.out.println("oct = " + oct);
		System.out.println("hex = " + hex);
		
		System.out.println("bin = " + Integer.toBinaryString(num1));
		System.out.println("oct = " + Integer.toOctalString(bin));
		System.out.println("hex = " + Integer.toHexString(hex));
	}

}
