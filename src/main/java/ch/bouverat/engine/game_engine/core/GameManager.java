package ch.bouverat.engine.game_engine.core;

import ch.bouverat.engine.game_engine.game.Game;

public class GameManager {
    public void start() {
        GameEngine gameEngine = new GameEngine();
        gameEngine.start();

        Game game = new Game();
        game.start();
    }

    public void stop() {
        //StopGame
    }
}
