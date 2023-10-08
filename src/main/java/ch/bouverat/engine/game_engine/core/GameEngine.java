package ch.bouverat.engine.game_engine.core;

import ch.bouverat.engine.game_engine.component.Collider;
import ch.bouverat.engine.game_engine.component.Transform;
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
        long lastTime = System.nanoTime();

        while (true) {
            long currentTime = System.nanoTime();
            long updateLength = currentTime - lastTime;
            lastTime = currentTime;
            deltaTime = updateLength / 1_000_000_000.0;

            for (int i = 0; i < BehaviourManager.getBehaviourList().size(); i++) {
                GameBehaviour behaviour = BehaviourManager.getBehaviourList().get(i);
                if (behaviour != null) {
                    behaviour.update();
                    if (behaviour.hasComponent(Collider.class)) {
                        Collider collider = behaviour.getComponent(Collider.class);
                        collider.onCollision(behaviour.getComponent(Transform.class).position);
                    }
                }
            }
            try {
                int TARGET_FPS = 120;
                long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
                long sleepTime = (lastTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                }
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
