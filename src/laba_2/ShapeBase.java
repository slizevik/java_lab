package laba_2;

public abstract class ShapeBase {
    protected String color;

    public ShapeBase(String color) {
        this.color = color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    public String getColor() {
        return color;
    }
}
