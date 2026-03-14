package laba_2;

public class Rectangle_run {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(5.0, 3.0);
        rect1.displayInfo();

        // изменение размеров через сеттеры
        rect1.setLength(7.0);
        rect1.setWidth(4.0);
        System.out.println("Новая площадь прямоугольника 1: " + rect1.getArea());

    }
}
