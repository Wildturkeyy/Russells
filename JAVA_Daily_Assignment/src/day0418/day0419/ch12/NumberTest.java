package day0419.ch12;

public class NumberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("numbCount의 값: " + Number.numCounter + "\n");
		
		
		Number number1 = new Number();
		number1.increaseNum();
		System.out.println("numbCount의 값: " + Number.numCounter + "\n");
		
		Number number2 = new Number();
		number2.increaseNum();
		number2.increaseNum();
		
		System.out.println("numbCount의 값: " + Number.numCounter + "\n");
		System.out.println("numbCount의 값: " + number1.numCounter + "\n");
		System.out.println("numbCount의 값: " + number2.numCounter + "\n");
		
	}

}
