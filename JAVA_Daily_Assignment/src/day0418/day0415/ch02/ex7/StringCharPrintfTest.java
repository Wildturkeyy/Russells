package day0415.ch02.ex7;

public class StringCharPrintfTest {

	public static void main(String[] args) {

		// 서식 지정자를 이용해서 문자와 문자열 만들기
		String str = "Hello World!";
		String name = "홍길동";
		char grade = 'A';
		
		System.out.printf("%s\n", str);
//		System.out.printf("%f\n", str); // 출력할 데이터 타입과 맞지 않으면 에러 발생
		System.out.printf("%20s\n", str); // 20칸 확보 후, 오른쪽부터 채움
		System.out.printf("%-20s\n", str); // 20칸 확보 후, 왼쪽부터 채움
		System.out.printf("학생의 이름은 %s 입니다.\n", name);
		
		System.out.printf("학점은 %c 입니다. \n", grade); // 문자를 출력
				
	}

}
