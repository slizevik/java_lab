package laba_2;

public class CircleShape extends ShapeBase {
        private double radius;

        public CircleShape(String color, double radius) {
            super(color);
            this.radius = radius;
        }

        public double getArea() {
            return 3.14 * radius * radius;
        }

        public double getPerimeter() {
            return 2 * 3.14 * radius;
        }
}
