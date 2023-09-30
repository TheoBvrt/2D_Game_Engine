package ch.bouverat.engine.game_engine;

import ch.bouverat.engine.game_engine.core.GameEngine;
import ch.bouverat.engine.game_engine.core.GameManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GameManager gameManager = new GameManager();
        gameManager.start();
    }

    public static void main(String[] args) {
        launch();
    }
}