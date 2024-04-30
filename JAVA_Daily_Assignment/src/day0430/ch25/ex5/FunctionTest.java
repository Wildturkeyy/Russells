package day0430.ch25.ex5;

import java.util.function.*;

public class FunctionTest {
    public static void main(String[] args) {

        Function<Student, String> function = student -> student.getName();

        String name = function.apply(new Student("홍길동", 2));
        System.out.println("학생이름: " + name);
        System.out.println();

        IntFunction<Double> intFunction = value -> (3.28084 * value);
        double feet1 = intFunction.apply(3);
        System.out.println("3 --> " + feet1);

        DoubleFunction<Integer> doubleFunction = value -> (int)(value/3.28084);
        int meter1 = doubleFunction.apply(feet1);
        System.out.println("feet1 -> " + meter1);
        System.out.println();

        IntToDoubleFunction intToDoubleFunction = value -> (value/3.28084);
        double feet2 = intToDoubleFunction.applyAsDouble(3);
        System.out.println("3 -> " + feet2);
        System.out.println();

        BiFunction<String, Integer, String> biFunction = (nameValue, ageValue) -> "이름: " +nameValue+ ", 나이: " + ageValue;
        String info = biFunction.apply("이순신", 18);
        System.out.println(info);


    }
}
