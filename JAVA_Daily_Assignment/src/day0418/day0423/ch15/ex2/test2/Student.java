package day0423.ch15.ex2.test2;

public class Student {
    String name;
    int grade;

    public Student(){
        this("홍길동", 3);
    }

    public Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        String info = "이름: " + name + ", 학년: " + grade;
        return info;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
