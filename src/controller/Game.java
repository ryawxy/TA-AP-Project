package controller;

import model.Circle;
import model.Curve;
import model.GameObject;
import model.Point;
import view.CircleView;
import view.CurveView;
import view.Paintable;
import view.frame.GameFrame;
import view.panel.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private static Game instace = new Game();

    private List<Curve> curves = new ArrayList<>();
    private List<GameObject> gameObjects = new ArrayList<>();

    public static Game getInstance() {
        return instace;
    }

    private Game() {

    }

    public void start() {
        GamePanel panel = new GamePanel(getAllPaintables());
        GameController controller = new GameController(panel);
        controller.moveFirstObject();
        controller.moveSecondObject();
        GameFrame frame = new GameFrame(panel);

        GameLoop gameLoop = new GameLoop(controller);
        gameLoop.start();
    }

    public List<Curve> getCurves() {
        return this.curves;
    }

    public List<GameObject> getGameObjects() {
        return this.gameObjects;
    }

    public void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public void setCurves(List<Curve> curves) {
        this.curves = curves;
    }

    public List<Paintable> getAllPaintables() {
        List<Paintable> paintables = new ArrayList<>();
        for (Curve curve : curves) {
            paintables.add(new CurveView(curve));
        }

        for (GameObject object : gameObjects) {
            if (object instanceof Circle) {
                paintables.add(new CircleView((Circle) object));
            }
        }

        return paintables;
    }
}