package controller;

import model.Curve;
import model.Point;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private static Curve curve;
    List<Point> points = new ArrayList<>();

    public Game() {
        createCurve();
    }

    private void createCurve(){

        points.add(new Point(100, 300));
        points.add(new Point(350, 500));
        points.add(new Point(500, 600));

        curve = new Curve(points);
    }
    private void createCircle(){
        //todo : fill it like createcurve method
    }

    public static Curve getCurve() {
        return curve;
    }
}
