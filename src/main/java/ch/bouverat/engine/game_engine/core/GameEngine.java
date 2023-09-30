package ch.bouverat.engine.game_engine.core;

public class GameEngine {
    public void start () {
        Thread thread = new Thread(this::gameLoop);
        thread.start();
    }

    private void gameLoop() {
        double lastTime = System.nanoTime();
        while (true) {
            double currentTime = System.nanoTime();
            double deltaTime = (currentTime - lastTime) / 1_000_000_000.0;
            for (int i = 0; i < BehaviourManager.getBehaviourList().size(); i++) {
                GameBehaviour behaviour = BehaviourManager.getBehaviourList().get(i);
                if (behaviour != null) {
                    behaviour.setDeltaTime(deltaTime);
                    behaviour.update();
                }
            }
        }
    }
}
