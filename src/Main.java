import java.util.ArrayList;
import java.util.List;

import controller.GameController;
import controller.GameLoop;
import model.Curve;
import model.GameObject;
import model.Point;
import view.frame.GameFrame;
import view.panel.GamePanel;

public class Main {
    static Curve curve;
    static List<Point> points = new ArrayList<>();
    static List<GameObject> gameObjects = new ArrayList<>();

    public static void main(String[] args) {
        points.add(new Point(50, 300)); // P0: Start
        points.add(new Point(150, 200)); // P1: Control up
        points.add(new Point(250, 300)); // P2: End valley

        points.add(new Point(350, 400)); // P3: Control down
        points.add(new Point(450, 300)); // P4: End peak

        points.add(new Point(550, 200)); // P5: Control up
        points.add(new Point(650, 300)); // P6: End valley

        curve = new Curve(points);

        GamePanel panel = new GamePanel(curve);
        GameController controller = new GameController(curve, panel);
        controller.moveFirstObject(0.0);
        GameFrame frame = new GameFrame(panel);

        GameLoop gameLoop = new GameLoop(controller);
        gameLoop.start();

        // controller.add
    }
}
