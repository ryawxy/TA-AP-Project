package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import model.Circle;
import model.Curve;
import model.GameObject;
import model.Point;
import view.panel.GamePanel;

public class GameController {
    private Curve curve;
    private List<Point> points = new ArrayList<>();
    private List<GameObject> gameObjects = new ArrayList<>();

    private GamePanel panel;

    private double currentT = 0;

    public GameController(Curve curve, GamePanel panel) {
        this.panel = panel;
        this.curve = curve;
        initGameObjects();
    }

    public void initGameObjects() {
        Circle circle = new Circle(40, 100, 100, 2, Color.GREEN);
        this.gameObjects.add(circle);
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
            currentT += 2*0.001;
        } else {
            currentT = 0;
        }
    }

    public void moveFirstObject(double t) {
        moveObjectAlongCurve(curve, this.gameObjects.get(0), t);
        this.panel.setGameObjects(this.gameObjects);
        refreshPanel();
    }

    public void moveObjectAlongCurve(Curve curve, GameObject gameObject, double t) {
        List<Point> points = curve.getPoints();

        if (points.size() < 3) {
            throw new IllegalArgumentException("Curve must have at least 3 points.");
        }

        int numSegments = (points.size() - 1) / 2; // Each curve segment uses 3 points (P0, P1, P2), next curve: P2, P3,
                                                   // P4

        if (numSegments <= 0) {
            throw new IllegalArgumentException("Invalid number of points for segments.");
        }

        // Find which segment t belongs to
        double segmentLength = 1.0 / numSegments;
        int segmentIndex = Math.min((int) (t / segmentLength), numSegments - 1);

        // Calculate local t for that segment
        double tStart = segmentIndex * segmentLength;
        double tEnd = tStart + segmentLength;
        double localT = (t - tStart) / segmentLength;

        // Get correct three points
        int pointIndex = segmentIndex * 2;
        Point p0 = points.get(pointIndex);
        Point p1 = points.get(pointIndex + 1);
        Point p2 = points.get(pointIndex + 2);

        // Interpolate
        Point result = interpolateQuadratic(p0, p1, p2, localT);

        // Move game object centered on the point
        gameObject.move(result.getX() - (gameObject.getWidth() / 2), result.getY() - (gameObject.getHeight() / 2));
    }

    public static Point interpolateQuadratic(Point p0, Point p1, Point p2, double t) {
        double x = Math.pow(1 - t, 2) * p0.getX() +
                2 * (1 - t) * t * p1.getX() +
                Math.pow(t, 2) * p2.getX();

        double y = Math.pow(1 - t, 2) * p0.getY() +
                2 * (1 - t) * t * p1.getY() +
                Math.pow(t, 2) * p2.getY();

        return new Point((int) x, (int) y);
    }
}
