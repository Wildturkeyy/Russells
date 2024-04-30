package day0430.ch25.ex5;

public class Student {
    String name;
    int age;

    public Student(String name, int grade) {
        this.name = name;
        this.age = grade;
    }

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
}
