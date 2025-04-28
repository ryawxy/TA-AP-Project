package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Circle extends GameObject {

    private int radius;

    public Circle(int radius, int x, int y, int speed, Color color) {
        super(color, speed, x, y, radius, radius);
        this.radius = radius;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fillOval(this.getX(), this.getY(), this.getRadius(), this.getRadius());
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
