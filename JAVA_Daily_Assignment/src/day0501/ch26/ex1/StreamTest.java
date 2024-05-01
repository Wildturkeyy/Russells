package day0501.ch26.ex1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {

        List<String> fruitList1 = Arrays.asList("apple", "banana",  "orange", "mango", "strawberry");
        Iterator<String> iterator1 = fruitList1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println();

        //Stream을 사용할 경우
        List<String> fruitList2 = Arrays.asList("apple", "banana", "orange", "mango", "strawberry");
        Stream<String> fruitStream1 = fruitList2.stream();
        fruitStream1.forEach(name -> System.out.println(name));

    }

}
