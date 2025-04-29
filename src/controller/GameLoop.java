package controller;

public class GameLoop extends Thread {
    GameController controller;
    private static int FRAME_RATE = 120;

    public GameLoop(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FRAME_RATE;
        double timePerUpdate = 1000000000.0 / FRAME_RATE;

        long previousTime = System.nanoTime();

        long lastCheck = System.currentTimeMillis();

        double deltaUpdate = 0;
        double deltaFrame = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaUpdate += (currentTime - previousTime) / timePerUpdate;
            deltaFrame += (currentTime - previousTime) / timePerFrame;

            previousTime = currentTime;

            if (deltaUpdate >= 1) {
                deltaUpdate--;
            }

            if (deltaFrame >= 1) {

                // TODO
                controller.updateGame();

                deltaFrame--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();

            }
        }
    }
}
