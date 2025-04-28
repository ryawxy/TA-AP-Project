package view.panel;

import javax.swing.JPanel;

import model.Curve;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import model.Point;

public class GamePanel extends JPanel {
    Curve curve;
    List<Point> points = new ArrayList<>();

    public GamePanel() {
        this.setBackground(Color.BLACK); // Set the panel background to black

        points.add(new Point(100, 300));
        points.add(new Point(350, 500));
        points.add(new Point(500, 600));

        curve = new Curve(points);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        curve.draw(g2d);
    }
}