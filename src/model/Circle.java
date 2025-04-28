package model;

public class Circle  {

    private double radius;
    private double x;
    private double y;
    private double speed;

    public Circle(double radius, double x, double y, double speed) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


}
