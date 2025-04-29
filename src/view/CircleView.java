package view;

import controller.Game;
import model.Circle;
import java.awt.Graphics2D;

public class CircleView {
    private final Circle circle  = Game.getCircleInstance();

    public void paint(Graphics2D g) {
        if (circle != null) {
            g.setColor(circle.getColor());
            g.fillOval(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight());
        }
    }
}