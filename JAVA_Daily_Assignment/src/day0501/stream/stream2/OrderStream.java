package day0501.stream.stream2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrderStream {
    public static void main(String[] args) {

        System.out.println("기본 정렬");
        List<String> list = Arrays.asList("홍길동", "김유신", "이순신" , "유관순");
        list.stream().sorted().forEach(System.out::println);

        System.out.println("역순 정렬");
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
