package day0501.ch26.ex5;

public class Student implements Comparable<Student>{
    public  static int MALE = 1;
    public  static int FEMALE = 2;

    private String name;
    private int age;
    private int score;
    private int gender;

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

    public Student(String name, int age, int score, int gender) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.gender = gender;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    //Comparable 인터페이스 구현

    @Override
    public int compareTo(Student o) {
        return Integer.compare(score, o.score);
    }

    @Override
    public String toString() {
        String info = name + ", " + age + ", " + score + ", " + gender;
        return info;
    }
}
