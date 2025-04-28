package model;

import java.util.List;

public class Curve {
    private List<Point> points;
    private int stroke = 2;

    public Curve(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public int getStroke() {
        return this.stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }
}