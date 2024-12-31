abstract class ThreeDShape extends Shape {
    public ThreeDShape() {
        super();
    }

    public ThreeDShape(String color) {
        super(color);
    }

    public abstract double getVolume();
}