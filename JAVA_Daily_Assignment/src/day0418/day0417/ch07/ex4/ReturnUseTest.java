package day0417.ch07.ex4;

public class ReturnUseTest {

	public static void main(String[] args) {
		// return문을 이용해서 메서드 종료하기
		ReturnUseTest m = new ReturnUseTest();
		m.printSumTo100();
		
		System.out.println("종료");
		
	}
	
	public void printSumTo100() {
		int sum = 0, i = 0;
		while (true) {
			sum += i;
			if (sum>=1000) {
				System.out.println("i = "+i+", sum = "+sum);
				return;
//				System.out.println("i = "+i+", sum = "+sum); // return 다음 구문은 실행하지 않으므로 에러 발생
				
			}else {
				i+=2;
			}
		}
	}

}
