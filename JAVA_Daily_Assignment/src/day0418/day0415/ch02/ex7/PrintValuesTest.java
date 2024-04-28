package day0415.ch02.ex7;

public class PrintValuesTest {

	public static void main(String[] args) {

		//여러 개의 값을 동시에 출력하기
		
		int num1 = 10, num2 = 20, num3 = 30;
		double height = 178.93;
		String name = "홍길동";
		char grade = 'A';
		
		System.out.printf("%d %d %d\n", 100, 200, 300);
//		System.out.printf("%d %d %d\n", 100, 200); // 예외 발생
		System.out.printf("%d %d \n\n", 100, 200, 300);
		
		System.out.printf("%d %d %d\n", num1, num2, num3); // 정수값들은 서식지정자의 형식에 맞는 정수로 출력
		System.out.printf("%o %o %x\n\n", num1, num2, num3);
		
		System.out.printf("%d, %.4f, %s\n\n", 100, 3.141597, "Hello World!");
		
		System.out.printf("이름 : %s, 키 : %.4f, 학점 : %c\n", name, height, grade);
		System.out.printf("이름 : %s\t 키 : %.4f\t 학점 : %c\n", name, height, grade);
		System.out.printf("학생의 이름은 %s이고, 학점은 '%c'입니다.", name, grade);
	}

}
