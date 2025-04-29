package controller;

import model.Curve;
import model.GameObject;
import model.Point;

import java.util.List;

public class MovementController {

    public void moveAlongCurve(GameObject object, Curve curve, double t) {
        List<Point> points = curve.getPoints();
        int numSegments = (points.size() - 1) / 2;

        double segmentLength = 1.0 / numSegments;
        int segmentIndex = Math.min((int) (t / segmentLength), numSegments - 1);

        double tStart = segmentIndex * segmentLength;
        double localT = (t - tStart) / segmentLength;

        int pointIndex = segmentIndex * 2;
        Point p0 = points.get(pointIndex);
        Point p1 = points.get(pointIndex + 1);
        Point p2 = points.get(pointIndex + 2);

        Point result = interpolateQuadratic(p0, p1, p2, localT);

        // Center the object on the calculated point
        object.move(result.getX() - (object.getWidth() / 2), result.getY() - (object.getHeight() / 2));
        object.setCurrentT(object.getCurrentT() + (object.getSpeed() * GameObject.CONSTANT_SPEED_FACTOR));
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