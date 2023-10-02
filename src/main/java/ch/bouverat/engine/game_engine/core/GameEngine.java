package ch.bouverat.engine.game_engine.core;

import ch.bouverat.engine.game_engine.settings.WindowSettings;
import javafx.scene.canvas.GraphicsContext;

public class GameEngine {
    public WindowSettings projectConfiguration;
    private GraphicsContext graphicsContext;

    public static double deltaTime;

    public GameEngine (WindowSettings projectConfiguration, GraphicsContext graphicsContext) {
        this.projectConfiguration = projectConfiguration;
        this.graphicsContext = graphicsContext;
    }

    public void start () {
        RenderLoop renderLoop = new RenderLoop(graphicsContext);
        renderLoop.start();
        Thread thread = new Thread(this::gameLoop);
        thread.start();
    }

    private void gameLoop() {
        double lastTime = System.nanoTime();
        while (true) {
            double currentTime = System.nanoTime();
            deltaTime = (currentTime - lastTime) / 1_000_000_000.0;
            for (int i = 0; i < BehaviourManager.getBehaviourList().size(); i++) {
                GameBehaviour behaviour = BehaviourManager.getBehaviourList().get(i);
                if (behaviour != null) {
                    behaviour.update();
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }
    }
}
