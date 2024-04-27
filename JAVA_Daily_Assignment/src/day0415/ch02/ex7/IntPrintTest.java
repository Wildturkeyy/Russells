package day0415.ch02.ex7;

public class IntPrintTest {

	public static void main(String[] args) {

		//여러 서식 지정자로 정수 출력하기
		int num1 = 543;
		System.out.printf("%d\n",num1); //543을 10진수로 출력한 후 개행
		System.out.printf("num1의 값은 %d입니다.\n", num1);
		System.out.printf("%10d\n", num1); // 10칸을 확보한 후 오른쪽부터 채우면서 출력
		System.out.printf("%-10d\n", num1); // 10칸을 확보한 후 왼쪽부터 채우면서 출력
		System.out.printf("%010d\n\n", num1); //10칸을 확보한 후 오른쪽부터 채우면서 출력하되 빈칸은 0으로 채움
		
		System.out.printf("%o\n", num1); // 정수를 8진수로 출력
		System.out.printf("%x\n", num1); // 정수를 16진수로 출력
		System.out.printf("%X\n", num1);
		System.out.printf("%%d = %d 출력", 500); // % 기호를 출력하기 위해서는 앞에 %기호를 추가
		
		
	}
}
