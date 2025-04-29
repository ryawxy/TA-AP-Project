package view.panel;

import javax.swing.JPanel;

import controller.Game;
import model.Curve;
import model.GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    Curve curve;
    List<GameObject> gameObjects = new ArrayList<>();

    public GamePanel(Curve curve) {
        this.setBackground(Color.BLACK);

        this.curve = curve;
    }

    public void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        Game.getCurveView().paint(g2d);
        Game.getCircleView().paint(g2d);

//        for (GameObject object : gameObjects) {
//            object.draw(g2d);
//        }
    }
}