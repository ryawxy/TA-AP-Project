package view.panel;

import javax.swing.JPanel;

import model.Curve;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import model.Point;
import view.CurveView;

public class GamePanel extends JPanel {
    CurveView curveView = new CurveView();
    public GamePanel() {
        this.setBackground(Color.BLACK); // Set the panel background to black

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        curveView.paint(g2d);


    }
}