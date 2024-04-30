package sec04.p1211;

public class MethodReferenceTest {

	public static void main(String[] args) {
		// 1. Static Method Reference
		MyIntInterface mii1 = a -> Math.abs(a);
		printWithInt(mii1, -123);
		mii1 = Math::abs;
		printWithInt(mii1, -123);
		
		printWithInt(x -> Math.abs(x), -123);
		printWithInt(Math::abs, -123);
		
		// 람다식의 매개변수 모두가 순서대로 정적 메서드의 인자로 사용되어야 한다
		MyStudentInterface msi = (name, grade) -> Student.setStudent(name, grade);
		msi.set("홍길동", 1);
		msi = Student::setStudent;
		msi.set("이순신", 2);
		
		// 2. Instance Method Reference
		var kim = new Student();
		System.out.println(kim.getName());
		
		MyStudentNameInterface msni = (student, name) -> student.setName(name);
		msni.set(kim, "김유신");  // kim.setName("김유신");
		System.out.println(kim.getName());
		msni = Student::setName;
		msni.set(kim, "김김김");
		System.out.println(kim.getName());
		msni = Student::hello;
		msni.set(kim, "하이");
		msni.set(kim, "Guten tag!");
		
		// 3. (외부) 객체의 인스턴스 메서드 참조
		MyStudentGetStringInterface msgsi = () -> kim.getName();
		System.out.println(msgsi.get());
		msgsi = kim::getName;
		System.out.println(msgsi.get());
		
		// 4. Constructor Reference
		MyStudentFactoryInterface msfi = () -> new Student();
		var lee = msfi.create();
		System.out.println(lee instanceof Student);
		System.out.println(lee.getName());
		
		MyStudentFactoryInterface msfi1 = Student::new;  // () -> new Student()
		var park = msfi1.create();
		System.out.println(park instanceof Student);
		System.out.println(park.getName());
		
		MyStudentFactoryInterface2 msfi2 = Student::new; // name -> new Student(name);
		var choi = msfi2.create("최영");
		System.out.println(choi instanceof Student);
		System.out.println(choi.getName());
	}

	static void printWithInt(MyIntInterface mii, int x) {
		int result = mii.calculate(x);
		System.out.println("결과: " + result);
	}
}
