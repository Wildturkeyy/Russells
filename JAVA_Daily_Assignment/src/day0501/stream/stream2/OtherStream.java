package day0501.stream.stream2;

import java.util.Arrays;

public class OtherStream {
    public static void main(String[] args) {
        /*
        asDoubleStream()
        asLongStream()
        boxed() 메서드가 있는데 이 메서드들을 stream 객체를 형변환할 수 있는 메서드
         */
        int intArr[] = {10, 20, 30, 40, 50, 60};
        Arrays.stream(intArr).asDoubleStream().forEach(d -> System.out.println(d));

        Arrays.stream(intArr).boxed().forEach(i -> System.out.println(i.getClass()));

    }
}
