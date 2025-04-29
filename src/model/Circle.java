package model;

import java.awt.Color;

public class Circle extends GameObject {

    private int radius;

    public Circle(int radius, int x, int y, int speed, Color color) {
        super(color, speed, x, y, radius, radius);
        this.radius = radius;
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
