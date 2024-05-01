package day0501.ch26.ex4;

import java.util.Arrays;
import java.util.List;

public class PeekTest {
    public static void main(String[] args) {
        //
        List<String> fruitList = Arrays.asList("apple","banana","apple","mango","strawberry","banana", "mango");

       /* fruitList.stream()
                .distinct()
                .filter(s -> s.length() <8)
                .peek(a -> System.out.println(a));
        */

        fruitList.stream()
                .distinct()
                .filter(s -> s.length()<8)
                .peek(a->System.out.print("1" + a + " "))
//                .peek(System.out::println)
                .filter(s->s.startsWith("a"))
                .peek(a->System.out.print("2" + a + " "))
//                .peek(System.out::println)
                .forEach(System.out::print);
    }
}
