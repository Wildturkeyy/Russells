package day0426.ch17.ex5;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetMethodTest {
    public static void main(String[] args) {

        TreeSet<String> treeset = new TreeSet<>();
        treeset.add("홍길동");
        treeset.add("차범근");
        treeset.add("손흥민");
        treeset.add("유현진");
        treeset.add("손흥민");
        treeset.add("김유신");
        treeset.add("홍길동");
        System.out.println(treeset.toString());
        System.out.println();

        Iterator ite1 = treeset.iterator();
        System.out.println("오름차순으로 출력하기");
        System.out.println("-----------------------------");
        while(ite1.hasNext()){
            System.out.println(ite1.next());
        }

        System.out.println("\n오름차순으로 출력하기");
        System.out.println("-----------------------------");
        Iterator ite2 = treeset.descendingIterator();
        while(ite2.hasNext()){
            System.out.println(ite2.next());
        }

        //
        System.out.println();
        String name1 = (String) treeset.first();
        System.out.println("첫 번째 요소: " + name1);
        String name2 = (String) treeset.last();
        System.out.println("마지막 요소: " + name2);

        // 유현진 보다 작은 요소들
        SortedSet set1 = (SortedSet) treeset.headSet("유현진");
        System.out.println("유현진 보다 작은 요소: " + set1);
        SortedSet set2 = (SortedSet) treeset.tailSet("유현진");
        System.out.println("유현진보다 큰 요소: " + set2);

        System.out.println();
        SortedSet set3 = (SortedSet) treeset.subSet("손흥민", "차범근");
        System.out.println("손흥민과 차범근 사이 요소 얻기: " + set3);




    }
}
