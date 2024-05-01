package day0501.stream.stream1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectionToStream {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);

    }
}
