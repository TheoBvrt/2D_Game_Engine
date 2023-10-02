package ch.bouverat.engine.game_engine.core;

import ch.bouverat.engine.game_engine.settings.WindowSettings;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Window {
    private final WindowSettings windowSettings;
    private GraphicsContext graphicsContext;
    private Scene scene;

    public Window (WindowSettings windowSettings) {
        this.windowSettings = windowSettings;
        initWindow();
    }

    private void initWindow() {
        Stage stage = new Stage();
        stage.setTitle(windowSettings.windowName);
        Canvas canvas = new Canvas(windowSettings.screenWidth, windowSettings.screenHeight);

        graphicsContext = canvas.getGraphicsContext2D();
        scene = new Scene(new Pane(canvas));
        stage.setResizable(windowSettings.isResizable);
        stage.setScene(scene);
        stage.show();
    }

    public Scene getScene() {
        return scene;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }
}
