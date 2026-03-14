package laba_2;

public class Shape_run {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(5), new Square(4), new Triangle(3, 4, 5)};

        for (Shape shape : shapes) {
            System.out.println(shape.getName() + " Площадь: " + shape.getArea() + ", Периметр: " + shape.getPerimeter());
        }
    }
}
