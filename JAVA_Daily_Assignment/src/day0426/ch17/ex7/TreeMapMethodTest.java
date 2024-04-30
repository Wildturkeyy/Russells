package day0426.ch17.ex7;

import java.util.*;

public class TreeMapMethodTest {

    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("홍길동","서울시");
        treeMap.put("차범근", "대구시");
        treeMap.put("손흥민", "부산시");
        treeMap.put("유현진", "서울시");
        treeMap.put("박지성", "광주시");
        treeMap.put("이순신", "부산시");

        System.out.println(treeMap);
        System.out.println();

        Map<String, String> map = treeMap.descendingMap();
        System.out.println(map);

        Set<String> set1 = treeMap.keySet();
        Iterator<String> ite1 = set1.iterator();
        System.out.println("\n오름차순 key로 출력하기");
        System.out.println("----------------------------");
        while (ite1.hasNext()){
            String key = (String) ite1.next();
            String value = (String) treeMap.get(key);
            System.out.println(key + " = " + value);
        }

        System.out.println();
        System.out.println("\n내림차순 key로 출력하기");
        Set set2 = treeMap.descendingKeySet();
        Iterator ite2 = set2.iterator();
        while (ite2.hasNext()){
            String key = (String) ite2.next();
            String value = (String) treeMap.get(key);
            System.out.println(key + " = " + value);
        }

        System.out.println();
        String name1 = (String) treeMap.firstKey();
        System.out.println("첫 번째 키: " + name1);

        String name2 = (String) treeMap.lastKey();
        System.out.println("\n마지막 키: " + name2);

        SortedMap<String, String> map1 = (SortedMap) treeMap.headMap("유현진");
        System.out.println("\n유현진보다 작은 키: " + map1);

        SortedMap<String, String> map2 = (SortedMap)treeMap.tailMap("유현진");
        System.out.println("\n유현진보다 큰 키: " + map2);

        SortedMap<String, String> map3 = (SortedMap<String, String>) treeMap.subMap("손흥민","차범근");
        System.out.println("\n손흥민과 차범근 사이의 키: " + map3);



    }
}
