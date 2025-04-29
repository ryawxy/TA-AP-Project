package controller;

import model.GameObject;
import view.panel.GamePanel;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final List<GameObject> gameObjects = new ArrayList<>();
    private final GamePanel panel;
    private final MovementController movementController;
    private double currentT = 0;

    public GameController(GamePanel panel) {
        this.panel = panel;
        this.movementController = new MovementController();
        initGameObjects();
    }

    public void initGameObjects() {
        this.gameObjects.add(Game.getCircleInstance());
        this.panel.setGameObjects(this.gameObjects);
        refreshPanel();
    }

    public void refreshPanel() {
        this.panel.repaint();
        this.panel.revalidate();
    }

    public void updateGame() {
        if (currentT < 1) {
            moveFirstObject(currentT);
            currentT += 2 * 0.001;
        } else {
            currentT = 0;
        }
    }

    public void moveFirstObject(double t) {
        movementController.moveAlongCurve(gameObjects.get(0), Game.getCurve(), t);
        this.panel.setGameObjects(gameObjects);
        refreshPanel();
    }
}