package day0501.ch26.ex4;

import java.util.Arrays;
import java.util.List;

public class StreamSoredTest {
    public static void main(String[] args) {
        //sorted() 메서드로 스트림 요소 정렬
        List<Integer> scoreList = Arrays.asList(77, 67, 88, 98, 73, 68);
        scoreList.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
