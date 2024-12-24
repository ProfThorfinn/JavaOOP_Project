import java.util.Date;

interface Drawable {
    String howToDraw();
}

abstract class Shape implements Drawable {
    private Date dateCreated;
    private String color;

    public Shape() {
        this.dateCreated = new Date();
        this.color = "null";
    }

    public Shape(String color) {
        this.dateCreated = new Date();
        this.color = color;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle {side=" + radius + ", color='" + getColor() +
                "', area=" + getArea() + ", perimeter=" + getPerimeter() +
                ", dateCreated=" + getDateCreated() + "}";
    }
}

abstract class ThreeDShape extends Shape {
    public ThreeDShape() {
        super();
    }

    public ThreeDShape(String color) {
        super(color);
    }

    public abstract double getVolume();
}

class Cube extends ThreeDShape {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public Cube(String color, double side) {
        super(color);
        this.side = side;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public double getArea() {
        return 6 * side * side;
    }

    @Override
    public double getPerimeter() {
        return 12 * side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public String toString() {
        return "Cube {side=" + side + ", color='" + getColor() +
                "', area=" + getArea() + ", perimeter=" + getPerimeter() +
                ", volume=" + getVolume() + ", dateCreated=" + getDateCreated() + "}";
    }
}
