package day0501.ch26.ex4;

import java.util.Arrays;
import java.util.List;

public class FlatMapTest {
    public static void main(String[] args) {

        List<String> stuList = Arrays.asList("홍길동 2 80", "이순신 3 77", "손흥민 2 88");

        stuList.stream()
                .flatMap(element -> Arrays.stream(element.split(" ")))
                .forEach(token -> System.out.println(token));
    }
}
