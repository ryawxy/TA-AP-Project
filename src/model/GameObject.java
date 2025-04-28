package model;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class GameObject implements Movable {
    protected Color color;
    protected int speed;
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public GameObject(Color color, int speed, int x, int y, int width, int height) {
        this.color = color;
        this.speed = speed;
        this.width = width;
        this.height = height;

        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics2D graphics2d);

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }
}
