package view.panel;

import javax.swing.JPanel;

import controller.Game;
import model.Curve;
import model.GameObject;
import view.CurveView;
import view.Paintable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    List<Paintable> objects;

    public GamePanel(List<Paintable> objects) {
        this.setBackground(Color.BLACK);
        this.objects = objects;
    }

    public void setObjects(List<Paintable> objects) {
        this.objects = objects;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        // Game.getCurveView().paint(g2d);
        // Game.getCircleView().paint(g2d);

        for (Paintable object : this.objects) {
            object.paint(g2d);
        }
    }
}