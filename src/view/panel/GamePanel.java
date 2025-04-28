package view.panel;

import javax.swing.JPanel;

import model.Curve;
import model.GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import model.Point;

public class GamePanel extends JPanel {
    Curve curve;
    List<Point> points = new ArrayList<>();
    List<GameObject> gameObjects = new ArrayList<>();

    public GamePanel(Curve curve) {
        this.setBackground(Color.BLACK); // Set the panel background to black

        this.curve = curve;
    }

    public void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        curve.draw(g2d);

        for (GameObject object : gameObjects) {
            object.draw(g2d);
        }
    }
}