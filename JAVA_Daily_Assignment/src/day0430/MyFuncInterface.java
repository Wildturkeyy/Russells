package sec04.p1211;

@FunctionalInterface
public interface MyFuncInterface {
	void execute();
}

@FunctionalInterface
interface MyIntInterface {
	int calculate(int a);
}

@FunctionalInterface
interface MyStudentInterface {
	void set(String name, int grade);
}

@FunctionalInterface
interface MyStudentNameInterface {
	void set(Student s, String name);
}

@FunctionalInterface
interface MyStudentGetStringInterface {
	String get();
}

@FunctionalInterface
interface MyStudentFactoryInterface {
	Student create();
}

@FunctionalInterface
interface MyStudentFactoryInterface2 {
	Student create(String name);
}



