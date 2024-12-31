import java.util.Date;

abstract class Shape implements drawable {
    private Date dateCreated;
    private String color;

    public Shape() {
        this.dateCreated = new Date();
        this.color = "null";
    }

    public Shape(String color) {
       // this.dateCreated = new Date();
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