package view;

import controller.Game;
import model.Curve;
import model.Point;

import java.awt.*;
import java.awt.geom.QuadCurve2D;

public  class CurveView implements Paintable{
    private Curve model = Game.getCurve();
    @Override
    public void paint(Graphics2D g) {
            g.setColor(Color.RED);
            for (int i = 0; i < model.getPoints().size() - 2; i += 2) {
                model.Point start = model.getPoints().get(i);
                model.Point control = model.getPoints().get(i + 1);
                Point end = model.getPoints().get(i + 2);

                QuadCurve2D q = new QuadCurve2D.Float();
                q.setCurve(start.getX(), start.getY(), control.getX(), control.getY(), end.getX(), end.getY());
                g.draw(q);
            }
        }
    }

