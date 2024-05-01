package day0501.stream.stream2;

import java.util.Arrays;
import java.util.List;

public class FilterStream {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("홍길동", "김유신", "홍길동", "이순신" , "홍길동" , "유관순");
        list.stream().distinct().forEach(s -> System.out.println(s));
        System.out.println();

        //filter 사용
        list.stream().filter(s -> s.startsWith("홍")).forEach(s-> System.out.println(s));
        System.out.println();

        //
        list.stream().distinct().filter(s -> s.startsWith("홍")).forEach(s -> System.out.println(s));
    }
}
