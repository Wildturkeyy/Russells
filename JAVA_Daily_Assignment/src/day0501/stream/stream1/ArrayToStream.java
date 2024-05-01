package day0501.stream.stream1;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayToStream {

    public static void main(String[] args) {

        //배열을 스트림 객체로 생성
        String[] arr = new String[] {"a", "b", "c", "d", "e", "f"};
        Stream<String> stream1 = Arrays.stream(arr);
        stream1.forEach(s -> System.out.printf(s+ " ")) ;
        System.out.println();

        Stream<String> stream2 = Arrays.stream(arr, 2, 5);
        stream2.forEach(s -> System.out.printf(s+ " ")) ;
        System.out.println();
    }
}
