package day0501.stream.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

public class FlatMapStream {
    public static void main(String[] args) {
        /*
        Map 인터페이스의 key, value처럼 매핑되어 있는 개념
        - 스트림의 데이터를 매개변수로 받아 가공 후 새로운 스트림을만들어서 리턴

        flatXXX() 메서드
        - 다른 타입의 요소를 가진 스트림을 리턴
         */
        List<String> list1 = Arrays.asList("동해물과", "백두산이", "마르고 닳도록");
        list1.stream().flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(word -> System.out.println(word));

        List<String> list2 = Arrays.asList("1.1, 2.2, 3.3", "4.4, 5.5, 6.6");
        DoubleStream dsr = list2.stream().flatMapToDouble((data -> {
            String[] strArr = data.split(", ");
            double[] dArr = new double[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                dArr[i] = Double.parseDouble(strArr[i].trim());
            }
            return Arrays.stream(dArr);
        }));
        dsr.forEach(n -> System.out.println(n));

    }
}
