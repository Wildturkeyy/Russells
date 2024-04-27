package day0415.ch04.ex2;

public class AssingnmentOpTest {

	public static void main(String[] args) {

		//복합 대입 연산자 사용하기
		
		int sum = 6;
		int var1 = 4;
		
		sum += 4;
		System.out.println("sum : " + sum);
		
		sum = 6;
		sum *= 4;
		System.out.println("sum : " + sum);
		
		sum = 6;
		sum += var1;
		System.out.println("sum : " + sum);
		
		sum = 6;
		sum -= var1;
		System.out.println("sum : " + sum);
		
		sum = 6;
		sum *= var1;
		System.out.println("sum : " + sum);
		
		sum = 6;
		sum /= var1;
		System.out.println("sum : " + sum);
		
		sum = 6;
		sum %= var1;
		System.out.println("sum : " + sum);
	}

}
