package ch.bouverat.engine.game_engine.core;

import ch.bouverat.engine.game_engine.game.Game;
import ch.bouverat.engine.game_engine.settings.WindowSettings;

public class GameSetup {
    public void start() {
        WindowSettings windowSettings = new WindowSettings();

        windowSettings.isResizable = false;
        windowSettings.screenHeight = 480;
        windowSettings.screenWidth = 720;
        windowSettings.windowName = "Welcome to Java 2D Game engine !";

        Window window =  new Window(windowSettings);
        GameEngine gameEngine = new GameEngine(windowSettings, window.getGraphicsContext());
        new InputManager(window.getScene());
        gameEngine.start();

        Game game = new Game();
        game.start();
    }

    public void stop() {
        //StopGame
    }
}
