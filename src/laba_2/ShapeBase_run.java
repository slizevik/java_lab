package laba_2;

public class ShapeBase_run {
    public static void main(String[] args) {
        ShapeBase[] shapes = {new CircleShape("Красный", 5), new SquareShape("Синий", 4), new TriangleShape("Зеленый", 3, 4, 5)};

        for (ShapeBase shape : shapes) {
            System.out.println("Цвет: " + shape.getColor() + ", Площадь: " + shape.getArea() + ", Периметр: " + shape.getPerimeter());
        }
    }
}
