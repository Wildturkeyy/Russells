package day0501.stream.stream1;

import java.util.stream.Stream;

public class StreamByBuilder {
    public static void main(String[] args) {
        //메서드를 이용해 스트림 생성
        // 빌더 이용
        Stream stream1 = Stream.builder()
                .add("a")
                .add("b")
                .add("c")
                .add("d")
                .add("e")
                .add("f")
                .build();

        stream1.forEach(s->System.out.printf(s + " "));
        System.out.println();

        //제너레이트 메서드 사용
        Stream<String> stream2 = Stream.generate(()->"애국가").limit(10);
        stream2.forEach(s->System.out.printf(s + " "));
        System.out.println();

        // 이터레이트 메서드 사용
        Stream<Integer> stream3 = Stream.iterate(1, i->i+1).limit(10);
        stream3.forEach(i->System.out.printf(i + " "));

    }
}
