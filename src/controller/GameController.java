package controller;

import model.Circle;
import model.Curve;
import model.GameObject;
import model.Point;
import view.panel.GamePanel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final GamePanel panel;
    private final MovementController movementController;

    public GameController(GamePanel panel) {
        this.panel = panel;
        this.movementController = new MovementController();
        initGameObjects();
    }

    public void initGameObjects() {
        Game.getInstance().getGameObjects().add(createCircle());
        Game.getInstance().getCurves().add(createCurve());
        Game.getInstance().getGameObjects().add(createCircle(200, 100));

        panel.setObjects(Game.getInstance().getAllPaintables());
        refreshPanel();
    }

    private Curve createCurve() {
        List<Point> points = new ArrayList<>();

        // points.add(new Point(50, 300));
        // points.add(new Point(400, 50));
        // points.add(new Point(600, 500));

        points.add(new Point(50, 300));
        points.add(new Point(150, 200));
        points.add(new Point(250, 300));

        points.add(new Point(350, 400));
        points.add(new Point(450, 300));

        points.add(new Point(550, 200));
        points.add(new Point(650, 300));

        return new Curve(points);
    }

    private Circle createCircle() {
        return new Circle(40, 100, 100, 2, Color.GREEN);
    }

    private Circle createCircle(int x, int y) {
        return new Circle(40, x, y, 2, Color.GREEN);
    }

    public void refreshPanel() {
        this.panel.repaint();
        this.panel.revalidate();
    }

    public void updateGame() {
        moveFirstObject();
    }

    public void moveFirstObject() {
        movementController.moveAlongCurve(Game.getInstance().getGameObjects().get(0),
                Game.getInstance().getCurves().get(0), Game.getInstance().getGameObjects().get(0).getCurrentT());
        panel.setObjects(Game.getInstance().getAllPaintables());
        refreshPanel();

        if (Game.getInstance().getGameObjects().get(0).getCurrentT() >= 1.0) {
            Game.getInstance().getGameObjects().get(0).setCurrentT(0.0);
        }
    }
}