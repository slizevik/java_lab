package laba_2;

public class SquareShape extends ShapeBase {
    private double side;

    public SquareShape(String color, double side) {
        super(color);
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }
}