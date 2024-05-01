package day0501.ch26.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionToStreamTest {
    public static void main(String[] args) {
        //컬렉션에서 스트림 얻기
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("홍길동", 2));
        studentList.add(new Student("이순신", 3));
        studentList.add(new Student("박찬호", 1));
        studentList.add(new Student("손흥민", 2));

        Stream<Student> stream = studentList.stream();
        stream.forEach(s -> System.out.println(s.getName()));
        System.out.println();
    }
}
