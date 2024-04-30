package day0426.ch17.ex8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoxingUnboxingTest {

    public static void main(String[] args) {
        List<Integer> aList1 = new ArrayList<>();
        aList1.add(100); //aList1.add(new Integer(100))으로 자동 변환되어 저장됩니다.
        aList1.add(200);
        aList1.add(300);
        aList1.add(400);
        aList1.add(500);

        System.out.println(aList1);

        Integer num1 = aList1.get(0);
        System.out.println(num1.intValue());

        int num2 = aList1.get(1);
        System.out.println(num2); // Integer(100) 객체가 자동으로 100으로 변환되어서 출력됩니다.

        for (int i=0; i<aList1.size(); i++){
            int num3 = aList1.get(i);
            System.out.println(num3);
        }
        System.out.println();

        Map<String, Double> map1 = new HashMap<>();
        map1.put("홍길동", 178.9);
        map1.put("이순신", 179.5);
        map1.put("유현진", 188.8);
        map1.put("차범근", 178.7);

        Double height1 = map1.get("홍길동");
        System.out.println(height1);  //자동으로 double타입으로 변환

    }
}
