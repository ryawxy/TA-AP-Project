package view;

import java.awt.*;

import model.Circle;

public class CircleView implements Paintable {

    Circle cirle;

    public CircleView(Circle cirle) {
        this.cirle = cirle;
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.drawArc(cirle.getX(), cirle.getY(), cirle.getRadius(), cirle.getRadius(), 0, 0);
    }
}
