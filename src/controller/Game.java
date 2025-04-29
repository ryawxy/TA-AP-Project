package controller;

import model.Circle;
import model.Curve;
import model.Point;
import view.CircleView;
import view.CurveView;
import view.frame.GameFrame;
import view.panel.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private static Curve curveInstance;
    private static List<Point> points = new ArrayList<>();
    private static CurveView curveViewInstance;
    private static Circle circleInstance;
    private static CircleView circleViewInstance;

    public Game() {
        GamePanel panel = new GamePanel(Game.getCurve());
        GameController controller = new GameController(panel);
        controller.moveFirstObject(0.0);
        GameFrame frame = new GameFrame(panel);

        GameLoop gameLoop = new GameLoop(controller);
        gameLoop.start();
    }

    private static void createCurve() {
        points.add(new Point(50, 300));
        points.add(new Point(150, 200));
        points.add(new Point(250, 300));

        points.add(new Point(350, 400));
        points.add(new Point(450, 300));

        points.add(new Point(550, 200));
        points.add(new Point(650, 300));

        curveInstance = new Curve(points);
    }

    private static void createCircle() {
        circleInstance = new Circle(40, 100, 100, 2, Color.GREEN);
    }

    public static Curve getCurve() {
        if (curveInstance == null) {
            createCurve();
        }
        return curveInstance;
    }

    public static CurveView getCurveView() {
        if (curveViewInstance == null) {
            curveViewInstance = new CurveView();
        }
        return curveViewInstance;
    }

    public static Circle getCircleInstance() {
        if (circleInstance == null) {
            createCircle();
        }
        return circleInstance;
    }

    public static CircleView getCircleView() {
        if (circleViewInstance == null) {
            circleViewInstance = new CircleView();
        }
        return circleViewInstance;
    }
}