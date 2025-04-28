package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;
import java.util.List;

public class Curve {
    private List<Point> points;
    private int stroke = 2;

    public Curve(List<Point> points) {
        this.points = points;
    }

    public Curve(List<Point> points, int stroke) {
        this(points);
        this.stroke = stroke;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.RED);

        for (int i = 0; i < points.size() - 2; i += 2) {
            Point start = points.get(i);
            Point control = points.get(i + 1);
            Point end = points.get(i + 2);

            QuadCurve2D q = new QuadCurve2D.Float();
            q.setCurve(start.getX(), start.getY(), control.getX(), control.getY(), end.getX(), end.getY());
            g2d.draw(q);
        }
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