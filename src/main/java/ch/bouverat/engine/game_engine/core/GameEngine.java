package ch.bouverat.engine.game_engine.core;

import ch.bouverat.engine.game_engine.settings.WindowSettings;
import javafx.scene.canvas.GraphicsContext;

public class GameEngine {
    public WindowSettings projectConfiguration;
    private final GraphicsContext graphicsContext;

    public static double deltaTime;

    public GameEngine(WindowSettings projectConfiguration, GraphicsContext graphicsContext) {
        this.projectConfiguration = projectConfiguration;
        this.graphicsContext = graphicsContext;
    }

    public void start() {
        RenderLoop renderLoop = new RenderLoop(graphicsContext);
        renderLoop.start();

        Thread gameLoop = new Thread(this::gameLoop);
        gameLoop.start();

        Thread physicThread = new Thread(this::physicLoop);
        physicThread.start();
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

    private void physicLoop() {
        while (true) {
            for (int i = 0; i < BehaviourManager.getRigidBodyList().size(); i++) {
                BehaviourManager.getRigidBodyList().get(i).updateRigidBody();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }
    }
}
