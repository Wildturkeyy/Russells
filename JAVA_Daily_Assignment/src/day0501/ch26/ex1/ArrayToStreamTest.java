package day0501.ch26.ex1;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayToStreamTest {
    public static void main(String[] args) {
        //베열에서 스트림 얻기
        Student[] stuArr = {
                new Student("홍길동", 2),
                new Student("이순신", 2),
                new Student("박찬호", 1),
                new Student("손흥민", 2),
        };

        Stream<Student> stdStream = Arrays.stream(stuArr);
        stdStream.forEach(s -> System.out.println(s.getName()));
        System.out.println();

        int[] Arr = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(Arr);
        intStream.forEach(i -> System.out.print(i + ", "));
    }
}
