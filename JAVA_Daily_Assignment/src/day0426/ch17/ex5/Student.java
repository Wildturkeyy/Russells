package day0426.ch17.ex5;

public class Student implements Comparable{
    String name;
    int grade;
    int score;

    Student(){}

    Student(String name, int grade, int score){
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        if (score > ((Student)o).score){
            return 1;
        }else if (score == ((Student)o).score){
            return 0;
        }else {
            return -1;
        }
    }
}
