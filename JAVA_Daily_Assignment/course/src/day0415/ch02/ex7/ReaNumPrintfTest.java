package day0415.ch02.ex7;

public class ReaNumPrintfTest {

	public static void main(String[] args) {

		//여러 서식 지정자로 실수 출력하기
		
		float num1 = 6.5E5F;
		double num2 = 7.654321E-5d;
		double num3 = 3123.14159234234563;
		
		System.out.printf("%f\n", num1);
		System.out.printf("%15.5f\n", num1);
		System.out.printf("%-15.05f\n\n", num1);
		
		System.out.printf("%f\n", num2);
		// 15칸을 확보한 후 왼쪽부터 채우면서 소수점 이하 5자리까지 실수를 표시. 6자리에서 반올림됨
		System.out.printf("%15.9f\n", num2);
		// 15칸을 확보한 후 오른쪽부터 채우면서 소수점 이하 5자리까지 실수를 표시. 6자리에서 반올림
		System.out.printf("%-15.09f\n\n", num2);
		
		System.out.printf("%e\n", num3); // 실수를 지수 형식으로 출력
		System.out.printf("%15.7e\n", num3);
		System.out.printf("%-15.07e\n", num3);
	}

}
