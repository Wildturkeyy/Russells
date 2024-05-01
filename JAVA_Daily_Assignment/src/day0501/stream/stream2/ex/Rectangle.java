package day0501.stream.stream2.ex;

public class Rectangle extends Shape{
    int w, h;

    Rectangle(){
        this(1, 1);
    }

    public Rectangle(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    double area() {
        return (w * h);
    }

    @Override
    double length() {
        return (w + h) * 2;
    }

    @Override
    public String toString() {
        return "넓이: " + this.area();
    }

}
