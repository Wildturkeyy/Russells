package day0501.ch26.ex1;

public class Student {
    private String name;
    private int age;
    private int score;

    //생성자 호출
    public Student() {}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    //
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
